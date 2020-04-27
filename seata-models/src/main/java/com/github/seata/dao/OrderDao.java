package com.github.seata.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.seata.models.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author dengmin
 * @Created 2020/4/23 11:10
 */
@Mapper
public interface OrderDao extends BaseMapper<Order> {

}
