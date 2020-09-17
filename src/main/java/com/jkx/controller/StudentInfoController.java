package com.jkx.controller;


import cn.hutool.json.JSONObject;
import com.jkx.common.DataResult;
import com.jkx.service.impl.StudentInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author leixuesong
 * @since 2020-09-17
 */

@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {

    @Autowired
    StudentInfoServiceImpl studentService;

    @GetMapping("/getSome")
    public DataResult getSome() {
        List<Map<String, String>> studentInfo = studentService.getAll();
        int ok = 0;
        JSONObject jsonObject = new JSONObject();
        if (studentInfo != null) {
            ok = 1;
        }
        jsonObject.put("ok", ok);
        jsonObject.put("data", studentInfo);
        return DataResult.success(studentInfo);
    }
}

