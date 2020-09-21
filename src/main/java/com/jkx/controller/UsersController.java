package com.jkx.controller;


import com.jkx.common.annotation.Admin;
import com.jkx.common.annotation.TokenRequired;
import com.jkx.common.util.Res;
import com.jkx.entity.User;
import com.jkx.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 用户控制器
 * @author leixuesong
 * @since 2020-09-17
 */
@RestController
@RequestMapping("/users")
@TokenRequired
public class UsersController {

    @Autowired
    IUsersService usersService;

    /**
     * 获取用户列表
     * @return 用户列表
     */
    @Admin
    @GetMapping("/list")
    public Res list(){
        List<User> list = usersService.list();
        return Res.ok(list);
    }

    /**
     * 新增用户
     * @param users user
     * @return res
     */
    @Admin
    @PostMapping("/save")
    public Res save(User users) {
        boolean save = usersService.save(users);
        if (save) {
            return Res.ok();
        } else {
            return Res.error("添加失败");
        }
    }

    /**
     * 检查 account 是否重复
     * @param account 账号
     * @return res
     */
    @GetMapping("/account-repeat")
    public Res getById(String account) {
        User user = usersService.findByAccount(account);
        HashMap<String, Boolean> map = new HashMap<>(2);
        map.put("valid", user == null);
        return Res.ok(map);
    }

}

