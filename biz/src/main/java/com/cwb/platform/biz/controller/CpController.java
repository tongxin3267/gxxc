package com.cwb.platform.biz.controller;

import com.cwb.platform.biz.model.BizCp;
import com.cwb.platform.biz.service.CpService;
import com.cwb.platform.sys.base.BaseController;
import com.cwb.platform.sys.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 产品管理
 *
 */
@RestController
@RequestMapping("/api/cp")
public class CpController extends BaseController<BizCp,String>{
    @Autowired
    private CpService service;

    @Override
    protected BaseService<BizCp, String> getBaseService() {
        return service;
    }

}
