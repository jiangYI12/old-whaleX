/*
 *
 *      Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the pig4cloud.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: lengleng (wangiegie@gmail.com)
 *
 */

package com.whalex.userCentre.api.dto;

import com.whalex.userCentre.api.entity.SysMenu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @description: 菜单树
 * @author: 🐋鲸鱼
 * @date: 2020/7/23
 */
@Data
@ApiModel(value = "菜单树")
@EqualsAndHashCode(callSuper = true)
public class MenuTree extends TreeNode implements Serializable {

	/**
	 * 菜单图标
	 */
	@ApiModelProperty(value = "菜单图标")
	private String icon;

	/**
	 * 菜单名称
	 */
	@ApiModelProperty(value = "菜单名称")
	private String name;

	private boolean spread = false;

	/**
	 * 前端路由标识路径
	 */
	@ApiModelProperty(value = "前端路由标识路径")
	private String path;

	/**
	 * 路由缓冲
	 */
	@ApiModelProperty(value = "路由缓冲")
	private String keepAlive;

	/**
	 * 权限编码
	 */
	@ApiModelProperty(value = "权限编码")
	private String permission;


	/**
	 * 菜单标签
	 */
	@ApiModelProperty(value = "菜单标签")
	private String label;

	/**
	 * 排序值
	 */
	@ApiModelProperty(value = "排序值")
	private Integer sort;

	/**
	 * 是否包含子节点
	 *
	 * @since 3.7
	 */
	private Boolean hasChildren;

	public MenuTree() {
	}

	public MenuTree(Long id, String name, Long parentId) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.label = name;
	}

	public MenuTree(Long id, String name, MenuTree parent) {
		this.id = id;
		this.parentId = parent.getId();
		this.name = name;
		this.label = name;
	}

	public MenuTree(SysMenu menuVo) {
		this.id = menuVo.getId();
		this.parentId = menuVo.getParentId();
		this.icon = menuVo.getIcon();
		this.name = menuVo.getName();
		this.path = menuVo.getPath();
		this.permission = menuVo.getPermissionName();
		this.label = menuVo.getName();
		this.sort = menuVo.getSort();
		this.keepAlive = menuVo.getKeepAlive();
	}

}
