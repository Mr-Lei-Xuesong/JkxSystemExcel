package com.jkx.service.impl;

import com.jkx.entity.Users;
import com.jkx.dao.IUsersDao;
import com.jkx.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-09-17
 */
@Service
public class UsersServiceImpl extends ServiceImpl<IUsersDao, Users> implements IUsersService {

}
