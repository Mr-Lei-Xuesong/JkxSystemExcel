package com.jkx.controller;

import com.jkx.common.util.Res;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员控制器
 * @author lx
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/test")
    public Res test(){
        return Res.ok();
    }

}
