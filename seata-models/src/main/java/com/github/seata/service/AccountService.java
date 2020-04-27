package com.github.seata.service;

/**
 * @Author dengmin
 * @Created 2020/4/23 11:11
 */
public interface AccountService {

    /**
     * @param userId 用户 ID
     * @param price 扣减金额
     */
    void reduceBalance(Long userId, Double price);

}
