package com.github.seata.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.seata.models.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author dengmin
 * @Created 2020/4/23 11:11
 */
@Mapper
public interface ProductDao extends BaseMapper<Product> {
}
