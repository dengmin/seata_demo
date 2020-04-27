package com.github.seata.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.seata.dao.OrderDao;
import com.github.seata.dto.PlaceOrderRequest;
import com.github.seata.models.Order;
import com.github.seata.models.OrderStatus;
import com.github.seata.service.AccountService;
import com.github.seata.service.PlaceOrderService;
import com.github.seata.service.ProductService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author dengmin
 * @Created 2020/4/23 11:16
 */
@Slf4j
@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Resource
    private OrderDao orderDao;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ProductService productService;

    @DS("order")
    @Override
    @Transactional
    @GlobalTransactional
    public void placeOrder(PlaceOrderRequest request) {
        log.info("=============ORDER START=================");
        Long userId = request.getUserId();
        Long productId = request.getProductId();
        Integer amount = request.getAmount();
        log.info("收到下单请求,用户:{}, 商品:{},数量:{}", userId, productId, amount);

        log.info("当前 XID: {}", RootContext.getXID());

        Order order = Order.builder()
                .userId(userId)
                .productId(productId)
                .status(OrderStatus.INIT)
                .amount(amount)
                .build();

        orderDao.insert(order);
        log.info("订单一阶段生成，等待扣库存付款中");
        // 扣减库存并计算总价
        Double totalPrice = productService.reduceStock(productId, amount);
        // 扣减余额
        accountService.reduceBalance(userId, totalPrice);

        order.setStatus(OrderStatus.SUCCESS);
        order.setTotalPrice(totalPrice);
        orderDao.updateById(order);
        log.info("订单已成功下单");
        log.info("=============ORDER END=================");
    }
}
