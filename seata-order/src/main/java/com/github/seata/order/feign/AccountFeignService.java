package com.github.seata.order.feign;

import com.github.seata.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author dengmin
 * @Created 2020/4/24 16:29
 */
@FeignClient("seata-account")
@RequestMapping("/account")
public interface AccountFeignService {

    @PostMapping("/reduce")
    public Result reduceBalance(@RequestParam("userId") Long userId, @RequestParam("price") double price);

}
