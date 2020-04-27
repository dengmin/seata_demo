package com.github.seata.order.service.impl;

import com.github.seata.dao.OrderDao;
import com.github.seata.models.Order;
import com.github.seata.models.OrderStatus;
import com.github.seata.order.dto.PlaceOrderRequest;
import com.github.seata.order.feign.AccountFeignService;
import com.github.seata.order.feign.ProductFeignService;
import com.github.seata.order.service.OrderService;
import com.github.seata.vo.Result;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author dengmin
 * @Created 2020/4/24 16:53
 */

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private AccountFeignService accountFeignService;
    @Resource
    private ProductFeignService productFeignService;

    @Resource
    private OrderDao orderDao;

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

        Result productResult = productFeignService.reduce(productId, amount);
        double totalPrice = Double.parseDouble(productResult.getData().toString());
        accountFeignService.reduceBalance(userId, totalPrice);
        order.setStatus(OrderStatus.SUCCESS);
        order.setTotalPrice(totalPrice);
        orderDao.updateById(order);
        log.info("订单已成功下单");
        log.info("=============ORDER END=================");
    }
}
