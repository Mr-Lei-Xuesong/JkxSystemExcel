package com.jkx.service;

import com.jkx.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2020-09-17
 */
public interface IUsersService extends IService<User> {
    /**
     * 根据账号查找 用户
     * @param account 账号
     * @return user
     */
    User findByAccount(String account);
}
