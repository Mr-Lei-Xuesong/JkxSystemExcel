package com.jkx.controller;

import com.jkx.common.exception.LoginException;
import com.jkx.common.form.LoginForm;
import com.jkx.common.util.JwtUtil;
import com.jkx.common.util.PasswordEncoder;
import com.jkx.common.util.Res;
import com.jkx.entity.User;
import com.jkx.service.IUsersService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 登录控制器
 * @author lx
 */
@RestController
public class LoginController {

    @Autowired
    IUsersService usersService;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * 登录
     * @param form 登录表单
     * @param response response
     * @return Res
     */
    @PostMapping("/login")
    public Res login(@RequestBody LoginForm form, HttpServletResponse response) {
        String token;
        User user = usersService.findByAccount(form.getAccount());
        if (user == null) {
            throw new LoginException(HttpStatus.SC_UNAUTHORIZED,"账号密码错误");
        }
        if (!passwordEncoder.encode(form.getPassword()).equals(user.getPassword())){
            throw new LoginException(HttpStatus.SC_UNAUTHORIZED,"账号密码错误");
        }
        token = JwtUtil.sign(user.getAccount(),user.getPassword());

        response.addHeader("Access-Control-Expose-Headers","token");
        response.addHeader("token",token);

        return Res.ok(user.getAccount());
    }
}
