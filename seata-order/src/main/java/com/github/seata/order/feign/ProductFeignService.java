package com.github.seata.order.feign;

import com.github.seata.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author dengmin
 * @Created 2020/4/24 16:52
 */
@FeignClient("seata-product")
@RequestMapping("/product")
public interface ProductFeignService {

    @PostMapping("/reduce")
    public Result reduce(@RequestParam("productId") long productId, @RequestParam("amount") int amount);

}
