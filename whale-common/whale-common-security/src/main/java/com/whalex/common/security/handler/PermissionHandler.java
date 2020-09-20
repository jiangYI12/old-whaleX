
package com.whalex.common.security.handler;


import com.whalex.common.core.baseEntity.WhaleUsers;
import com.whalex.common.core.util.AuthUtil;
import com.whalex.common.tool.webUtil.WebUtils;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 默认授权校验类
 *
 * @author livingdiy
 */
@Deprecated
@AllArgsConstructor
public class PermissionHandler implements IPermissionHandler {

	private static final String SCOPE_CACHE_CODE = "apiScope:code:";

//	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean permissionAll() {
//		HttpServletRequest request = WebUtils.getRequest();
//		WhaleUsers user = AuthUtil.getWhaleXUser();
//		if (request == null || user == null) {
//			return false;
//		}
//		String uri = request.getRequestURI();
//		List<String> paths = permissionPath(user.getRoleId());
//		if (paths.size() == 0) {
//			return false;
//		}
//		return paths.stream().anyMatch(uri::contains);
		return false;
	}

	@Override
	public boolean hasPermission(String permission) {
//		HttpServletRequest request = WebUtils.getRequest();
//		WhaleUsers user = AuthUtil.getWhaleXUser();
//		if (request == null || user == null) {
//			return false;
//		}
//		List<String> codes = permissionCode(permission, user.getRoleId());
//		return codes.size() != 0;
		return false;
	}

	/**
	 * 获取接口权限地址
	 *
	 * @param roleId 角色id
	 * @return permissions
	 */
//	private List<String> permissionPath(String roleId) {
//		List<String> permissions = CacheUtil.get(SYS_CACHE, SCOPE_CACHE_CODE, roleId, List.class);
//		if (permissions == null) {
//			List<Long> roleIds = Func.toLongList(roleId);
//			permissions = jdbcTemplate.queryForList(PermissionConstant.permissionAllStatement(roleIds.size()), roleIds.toArray(), String.class);
//			CacheUtil.put(SYS_CACHE, SCOPE_CACHE_CODE, roleId, permissions);
//		}
//		return permissions;
//	}

	/**
	 * 获取接口权限信息
	 *
	 * @param permission 权限编号
	 * @param roleId     角色id
	 * @return permissions
	 */
//	private List<String> permissionCode(String permission, String roleId) {
//		List<String> permissions = CacheUtil.get(SYS_CACHE, SCOPE_CACHE_CODE, permission + StringPool.COLON + roleId, List.class);
//		if (permissions == null) {
//			List<Object> args = new ArrayList<>(Collections.singletonList(permission));
//			List<Long> roleIds = Func.toLongList(roleId);
//			args.addAll(roleIds);
//			permissions = jdbcTemplate.queryForList(PermissionConstant.permissionStatement(roleIds.size()), args.toArray(), String.class);
//			CacheUtil.put(SYS_CACHE, SCOPE_CACHE_CODE, permission + StringPool.COLON + roleId, permissions);
//		}
//		return permissions;
//	}

}
