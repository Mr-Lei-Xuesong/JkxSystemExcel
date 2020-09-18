package com.jkx.controller;

import com.jkx.common.form.LoginForm;
import com.jkx.common.util.JwtUtil;
import com.jkx.common.util.PasswordEncoder;
import com.jkx.common.util.Res;
import com.jkx.entity.User;
import com.jkx.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录控制器
 * @author lx
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    IUsersService usersService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping
    public Res login(@RequestBody LoginForm form, HttpServletResponse response) {
        String token = null;
        User user = usersService.findByAccount(form.getAccount());
        if (user == null) {
            return Res.error("账号密码错误");
        }
        if (!passwordEncoder.encode(form.getPassword()).equals(user.getPassword())){
            return Res.error("账号密码错误");
        }
        token = JwtUtil.sign(user.getAccount(),user.getPassword());
        Cookie cookie = new Cookie("token",token);
        response.addCookie(cookie);
        response.addHeader("token",token);
        response.setHeader("token",token);
        return Res.ok(user.getAccount());
    }
}
