package com.github.seata.models;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Author dengmin
 * @Created 2020/4/23 11:08
 */
@Data
@Builder
public class Product {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 价格
     */
    private Double price;
    /**
     * 库存
     */
    private Integer stock;

    private Date lastUpdateTime;
}
