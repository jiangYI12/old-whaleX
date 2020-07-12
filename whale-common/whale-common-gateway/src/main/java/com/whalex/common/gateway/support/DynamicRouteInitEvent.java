package com.whalex.common.gateway.support;

import org.springframework.context.ApplicationEvent;

/**
 * @description: 路由初始化事件
 * @author: 🐋鲸鱼
 * @date: 2020/7/6
 */
public class DynamicRouteInitEvent extends ApplicationEvent {

	public DynamicRouteInitEvent(Object source) {
		super(source);
	}

}