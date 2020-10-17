package com.jkx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jkx.common.annotation.Admin;
import com.jkx.common.annotation.TokenRequired;
import com.jkx.common.exception.RegisterException;
import com.jkx.common.util.PasswordEncoder;
import com.jkx.common.util.Res;
import com.jkx.entity.User;
import com.jkx.service.IUsersService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 用户控制器
 *
 * @author leixuesong
 * @since 2020-09-17
 */
@RestController
@RequestMapping("/users")
@TokenRequired
public class UsersController {

    @Autowired
    IUsersService usersService;
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * 获取用户列表
     *
     * @return 用户列表
     */
    @Admin
    @GetMapping("/list")
    public Res list() {
        List<User> list = usersService.list();
        if (list.isEmpty()) {
            return Res.error("未查询到任何数据");
        } else {
            return Res.ok(list);
        }
    }

    /**
     * 新增用户
     *
     * @param users user
     * @return res
     */
    @Admin
    @PostMapping("/save")
    public Res save(User users) {
        User user = usersService.findByAccount(users.getAccount());
        if (user != null) {
            throw new RegisterException(HttpStatus.SC_INTERNAL_SERVER_ERROR, "用户名已存在");
        } else {
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            boolean save = usersService.save(users);
            if (save) {
                return Res.ok();
            } else {
                throw new RegisterException(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常");
            }
        }
    }

    /**
     * 按用户名删除
     *
     * @param account 用户名
     * @return res
     */
    @Admin
    @DeleteMapping("/del/{account}")
    public Res del(@PathVariable String account) {
        User user = usersService.findByAccount(account);
        if (user == null) {
            return Res.error("用户名不存在");
        } else {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("Account", account);
            boolean b = usersService.remove(wrapper);
            if (b) {
                return Res.ok("删除成功");
            } else {
                return Res.error("删除失败");
            }
        }
    }

    /**
     * 根据用户名查找
     *
     * @param account 用户名
     * @return res
     */
    @Admin
    @GetMapping("/get/{account}")
    public Res getAccount(@PathVariable String account) {
        User user = usersService.findByAccount(account);
        if (user == null) {
            return Res.error("用户名不存在");
        } else {
            return Res.ok(user);
        }
    }

    /**
     * 修改用户信息
     *
     * @param user 用户实体类
     * @return res
     */
    @Admin
    @PutMapping("/update")
    public Res update(User user) {
        User account = usersService.findByAccount(user.getAccount());
        if (account == null) {
            return Res.error("用户名不存在");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            boolean update = usersService.update(user, null);
            if (update) {
                return Res.ok("修改成功");
            } else {
                return Res.error("修改失败");
            }
        }
    }

    /**
     * 检查 account 是否重复
     *
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

