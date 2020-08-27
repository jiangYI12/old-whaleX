
package com.whalex.common.security.auth;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.whalex.common.core.baseEntity.WhaleUsers;
import com.whalex.common.core.util.AuthUtil;
import com.zwx.core.secure.UserType;
import com.zwx.core.secure.ZwxUser;
import com.zwx.core.secure.handler.IPermissionHandler;
import com.zwx.core.secure.utils.AuthUtil;
import com.zwx.core.tool.constant.RoleConstant;
import com.zwx.core.tool.utils.CollectionUtil;
import com.zwx.core.tool.utils.Func;
import com.zwx.core.tool.utils.SpringUtil;
import com.zwx.core.tool.utils.StringUtil;

import java.util.List;

/**
 * 权限判断
 * */
public class AuthFun {

	/**
	 * 权限校验处理器
	 */
	private static IPermissionHandler permissionHandler;

	private static IPermissionHandler getPermissionHandler() {
		if (permissionHandler == null) {
			permissionHandler = SpringUtil.getBean(IPermissionHandler.class);
		}
		return permissionHandler;
	}

	/**
	 * 判断角色是否具有接口权限
	 *
	 * @return {boolean}
	 */
	public boolean permissionAll() {
		return getPermissionHandler().permissionAll();
	}

	/**
	 * 判断角色是否具有接口权限
	 *
	 * @param permission 权限编号
	 * @return {boolean}
	 */
	public boolean hasPermission(String permission) {
		return getPermissionHandler().hasPermission(permission);
	}

	/**
	 * 放行所有请求
	 *
	 * @return {boolean}
	 */
	public boolean permitAll() {
		return true;
	}


	/**
	 * 判断是否有该角色权限
	 *
	 * @param role 单角色
	 * @return {boolean}
	 */
	public boolean hasRole(String role) {
		return hasAnyRole(role);
	}

	/**
	 * 判断是否有该角色权限
	 *
	 * @param role 角色集合
	 * @return {boolean}
	 */
	public boolean hasAnyRole(String... role) {
		WhaleUsers user = AuthUtil.getWhaleXUser();

		if (user == null) {
			return false;
		}

		List userRole = user.getRoles();
		if (CollUtil.isEmpty(userRole)) {
			return false;
		}

		for (String r : role) {
			if (userRole.contains(r)) {
				return true;
			}
		}
		return false;
	}

}
