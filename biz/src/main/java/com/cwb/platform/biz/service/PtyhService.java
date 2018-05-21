package com.cwb.platform.biz.service;


import com.cwb.platform.sys.base.BaseService;
import com.cwb.platform.sys.model.BizPtyh;
import com.cwb.platform.util.bean.ApiResponse;

import java.util.Map;

public interface PtyhService extends BaseService<BizPtyh,java.lang.String>{

    /**
     *  更新用户是否锁定状态 0 否 1 是
     * @param bizPtyh
     * @return
     */
    ApiResponse<String> updateSfsd(BizPtyh bizPtyh);
    /**
     * 更新用户是否分配信息
     * @param bizPtyh
     * @return
     */
    ApiResponse<String> updateSffp(BizPtyh bizPtyh);

    BizPtyh findByIdSelect(String userid);

    ApiResponse<String> userEnroll (BizPtyh entity);

    ApiResponse<String> mdfPwd(String userId, String oldPwd, String newPwd);

    ApiResponse<Map<String,Object>> wxlogin(String openId);

    ApiResponse<String> updateUserInfo(BizPtyh entity);

    ApiResponse<String> updateUserReal(BizPtyh entity);
}
