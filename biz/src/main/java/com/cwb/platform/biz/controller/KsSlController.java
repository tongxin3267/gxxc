package com.cwb.platform.biz.controller;

import com.cwb.platform.biz.model.BizKsSl;
import com.cwb.platform.biz.service.KsSlService;
import com.cwb.platform.sys.base.BaseService;
import com.cwb.platform.sys.base.QueryController;
import com.cwb.platform.util.bean.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 学员考试受理信息表
 * Created by Administrator on 2018/6/19.
 */
@RestController
@RequestMapping("/api/kssl")
public class KsSlController extends QueryController<BizKsSl,String> {

    @Autowired
    private KsSlService service;

    @Override
    protected BaseService<BizKsSl, String> getBaseService() {
        return service;
    }

    @RequestMapping(value="/save", method={RequestMethod.POST})
    public ApiResponse<String> save(BizKsSl entity){
        return service.validAndSave(entity);
    }

    @RequestMapping("getHandleStatus")
    public ApiResponse<Map<String,BizKsSl>> getHandleStatus(String yhId){
        return service.getHandleStatus(yhId);
    }


}
