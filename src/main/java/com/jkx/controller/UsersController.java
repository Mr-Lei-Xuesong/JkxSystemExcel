package com.jkx.controller;

import com.jkx.common.util.Res;
import com.jkx.entity.Users;
import com.jkx.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author leixuesong
 * @since 2020-09-17
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    IUsersService usersService;

    @GetMapping("/list")
    public Res getAll() {
        List<Users> list = usersService.list();
        if (list.isEmpty()) {
            return Res.error();
        } else {
            return Res.ok(list);
        }
    }

    @GetMapping("/get/{id}")
    public Res getById(@PathVariable Integer id) {
        Users byId = usersService.getById(id);
        if (byId != null) {
            return Res.ok(byId);
        } else {
            return Res.error("查无此人");
        }
    }

    @PostMapping("/save")
    public Res save(Users users) {
        boolean save = usersService.save(users);
        if (save) {
            return Res.ok();
        } else {
            return Res.error("添加失败");
        }
    }

    @PutMapping("/update")
    public Res update(Users users) {
        boolean update = usersService.update(users, null);
        if (update) {
            return Res.ok("修改成功");
        } else {
            return Res.error("修改失败");
        }
    }

    @DeleteMapping("/del/{id}")
    public Res del(@PathVariable Integer id) {
        boolean b = usersService.removeById(id);
        if (b) {
            return Res.ok("删除成功");
        } else {
            return Res.error("删除失败");
        }
    }
}

