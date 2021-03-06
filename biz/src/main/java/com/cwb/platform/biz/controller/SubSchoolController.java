package com.cwb.platform.biz.controller;

import com.cwb.platform.biz.model.BizSubSchool;
import com.cwb.platform.biz.service.SubSchoolService;
import com.cwb.platform.sys.base.BaseController;
import com.cwb.platform.sys.base.BaseService;
import com.cwb.platform.util.bean.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/subschool")
public class SubSchoolController extends BaseController<BizSubSchool,String> {
   @Autowired
   private SubSchoolService service;

    @Override
    protected BaseService<BizSubSchool, String> getBaseService() {
        return service;
    }

    @PostMapping("/save")
    public ApiResponse<String> save(BizSubSchool entity){
        return service.validAndSave(entity);
    }

    @PostMapping("/getOpenid")
    public ApiResponse<String> getOpenid(String phone){
        return service.getOpenid(phone);
    }

    @PostMapping("/update")
    public ApiResponse<String> update(BizSubSchool subSchool){
        return service.updateEntity(subSchool);
    }

}
