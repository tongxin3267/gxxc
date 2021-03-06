package com.cwb.platform.sys.service;

import com.cwb.platform.sys.base.BaseService;
import com.cwb.platform.sys.model.SysFw;
import com.cwb.platform.sys.model.SysYh;
import com.cwb.platform.util.bean.ApiResponse;

import java.util.List;

public interface YhService extends BaseService<SysYh, String> {

	List<SysYh> getByRoleIds(List<String> roleIds);
	/**
	 * 新增用户
	 * @param user 用户
	 * @return 执行结果
	 */
	ApiResponse<String> addUser(SysYh user);

	ApiResponse<String> saveEntity(SysYh entity);

	/**
	 * 修改登录密码
	 * @param userId 用户id
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
	 * @return 操作结果
	 */
	ApiResponse<String> mdfPwd(String userId, String oldPwd, String newPwd);

	ApiResponse<List<SysFw>> getUserPermissions(SysYh user);

    ApiResponse<String> updateEntity(SysYh user);

    ApiResponse<String> updateSession(SysYh user);

	/**
	 * 重置密码
	 * @param userId
	 * @return
	 */
	ApiResponse<String> resetPassword(String userId);
}