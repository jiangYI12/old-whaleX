
package com.whalex.common.security.aspect;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import com.whalex.common.core.baseEntity.WhaleUsers;
import com.whalex.common.core.util.AuthUtil;
import com.whalex.common.security.annotation.PreAuth;
import com.whalex.common.security.auth.AuthFun;
import com.whalex.common.security.customException.AuthorizedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.core.MethodParameter;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AOP 鉴权
 * https://docs.spring.io/spring/docs/4.3.10.RELEASE/spring-framework-reference/html/expressions.html el表达式官网
 * @author livingdiy
 */
@Aspect
public class AuthAspect implements ApplicationContextAware {

	/**
	 * 表达式处理
	 * SpelExpressionParser是Spring内部对ExpressionParser的唯一最终实现类
	 */
	private static final ExpressionParser SPEL_PARSER = new SpelExpressionParser();

	/**
	 * 切 方法 和 类上的 @PreAuth 注解
	 *
	 * @param point 切点
	 * @return Object
	 * @throws Throwable 没有权限的异常
	 */
	@Around(
		"@annotation(com.whalex.common.security.annotation.PreAuth) || " +
			"@within(com.whalex.common.security.annotation.PreAuth)"
	)
	public Object preAuth(ProceedingJoinPoint point) throws Throwable {
		if (handleAuth(point)) {
			return point.proceed();
		}
		throw new AuthorizedException("权限不足");
	}

	/**
	 * 处理权限
	 *
	 * @param point 切点
	 */
	private boolean handleAuth(ProceedingJoinPoint point) {
		MethodSignature ms = (MethodSignature) point.getSignature();
		Method method = ms.getMethod();
		// 读取权限注解，优先方法上，没有则读取类
		PreAuth preAuth = method.getAnnotation(PreAuth.class);

		// 判断表达式
		String condition = preAuth.value();

		if (!StringUtils.isEmpty(condition)) {
			//把该表达式，解析成一个Expression对象：SpelExpression
			Expression expression = SPEL_PARSER.parseExpression(condition);
			// 方法参数值
			Object[] args = point.getArgs();
			StandardEvaluationContext context = getEvaluationContext(method, args);
			return expression.getValue(context, Boolean.class);
		}

		//拓展hasRole写法
		String[] hasRole = preAuth.hasAnyRole();

		List<String> roleList = new ArrayList<>();
		if(!ObjectUtils.isEmpty(hasRole)&&hasRole.length>0){
			for(String role:hasRole){
			  roleList.add("'"+role+"'");
			}
			String roleNames = String.join(",",roleList);
			String roleExpression = "hasAnyRole("+roleNames+")";
			//把该表达式，解析成一个Expression对象：SpelExpression
			Expression expression = SPEL_PARSER.parseExpression(roleExpression);
			// 方法参数值
			Object[] args = point.getArgs();
			StandardEvaluationContext context = getEvaluationContext(method, args);
			return expression.getValue(context, Boolean.class);
		}

		return false;
	}

	/**
	 * 获取方法上的参数
	 *
	 * @param method 方法
	 * @param args   变量
	 * @return {SimpleEvaluationContext}
	 */
	private StandardEvaluationContext getEvaluationContext(Method method, Object[] args) {
		// 初始化Sp el表达式上下文，并设置 AuthFun
		StandardEvaluationContext context = new StandardEvaluationContext(new AuthFun());
		// 设置表达式支持spring bean
		context.setBeanResolver(new BeanFactoryResolver(applicationContext));
//		for (int i = 0; i < args.length; i++) {
//			// 读取方法参数
//			MethodParameter methodParam = ClassUtil.getMethodParameter(method, i);
//			// 设置方法 参数名和值 为sp el变量
//			context.setVariable(methodParam.getParameterName(), args[i]);
//		}
		return context;
	}

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
