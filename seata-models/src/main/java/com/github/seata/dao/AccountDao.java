package com.github.seata.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.seata.models.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author dengmin
 * @Created 2020/4/23 11:09
 */
@Mapper
public interface AccountDao extends BaseMapper<Account> {
}
