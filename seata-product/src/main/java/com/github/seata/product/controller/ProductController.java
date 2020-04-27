package com.github.seata.product.controller;

import com.github.seata.product.dto.ReduceStockRequest;
import com.github.seata.service.ProductService;
import com.github.seata.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author dengmin
 * @Created 2020/4/24 15:58
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService service;

    /**
     * 扣减库存并返回总价
     * @param request
     * @return
     */
    @PostMapping("/reduce")
    public Result reduceStock(long productId, int amount){
        double totalPrice = service.reduceStock(productId, amount);
        return Result.ok(totalPrice);
    }
}
