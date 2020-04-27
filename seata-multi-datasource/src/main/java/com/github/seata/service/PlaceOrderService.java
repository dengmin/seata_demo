package com.github.seata.service;

import com.github.seata.dto.PlaceOrderRequest;

/**
 * @Author dengmin
 * @Created 2020/4/23 11:12
 */
public interface PlaceOrderService {

    /**
     * 下单
     *
     * @param placeOrderRequest 订单请求参数
     */
    void placeOrder(PlaceOrderRequest placeOrderRequest);
}
