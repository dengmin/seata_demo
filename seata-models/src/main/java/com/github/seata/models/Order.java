package com.github.seata.models;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @Author dengmin
 * @Created 2020/4/23 11:07
 */
@Builder
@Data
@TableName("p_order")
public class Order {
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 商品ID
     */
    private Long productId;
    /**
     * 订单状态
     */
    private OrderStatus status;
    /**
     * 数量
     */
    private Integer amount;
    /**
     * 总金额
     */
    private Double totalPrice;
}
