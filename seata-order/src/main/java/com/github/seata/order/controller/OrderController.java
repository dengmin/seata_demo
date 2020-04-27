package com.github.seata.order.controller;

import com.github.seata.order.dto.PlaceOrderRequest;
import com.github.seata.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author dengmin
 * @Created 2020/4/24 16:16
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/place")
    public String placeOrder(@RequestBody PlaceOrderRequest request){
        orderService.placeOrder(request);
        return "ok";
    }

}
