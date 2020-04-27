package com.github.seata.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author dengmin
 * @Created 2020/4/23 11:13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReduceBalanceRequest {

    private Long userId;

    private double price;
}
