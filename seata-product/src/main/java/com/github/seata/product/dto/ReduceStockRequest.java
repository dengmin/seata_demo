package com.github.seata.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author dengmin
 * @Created 2020/4/23 11:14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReduceStockRequest {

    private Long productId;

    private Integer amount;
}
