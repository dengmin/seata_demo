package com.github.seata.order.service;

import com.github.seata.order.dto.PlaceOrderRequest;

/**
 * @Author dengmin
 * @Created 2020/4/24 16:20
 */
public interface OrderService {

    void placeOrder(PlaceOrderRequest placeOrderRequest);

}
