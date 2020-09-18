package com.jkx.dao;

import com.jkx.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2020-09-17
 */
@Repository
@Mapper
public interface IUsersDao extends BaseMapper<User> {
   /**
    * 根据账号查找 用户
    * @param account 账号
    * @return user
    */
   User findByAccount(String account);

}
