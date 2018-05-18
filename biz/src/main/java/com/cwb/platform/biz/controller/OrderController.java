package com.cwb.platform.biz.controller;

import com.cwb.platform.biz.model.BizOrder;
import com.cwb.platform.biz.service.OrderService;
import com.cwb.platform.sys.base.BaseController;
import com.cwb.platform.sys.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController extends BaseController<BizOrder,String>{
    @Autowired
    private OrderService service;

    @Override
    protected BaseService<BizOrder, java.lang.String> getBaseService() {
        return service;
    }
}
