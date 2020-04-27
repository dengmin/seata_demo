package com.github.seata.account.controller;

import com.github.seata.account.dto.ReduceBalanceRequest;
import com.github.seata.service.AccountService;
import com.github.seata.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author dengmin
 * @Created 2020/4/24 15:38
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/reduce")
    public Result reduceBalance(ReduceBalanceRequest request){
        accountService.reduceBalance(request.getUserId(), request.getPrice());
        return Result.ok("ok");
    }

}
