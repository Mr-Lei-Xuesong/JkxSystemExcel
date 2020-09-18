package com.jkx.controller;


import cn.hutool.json.JSONObject;
import com.jkx.common.DataResult;
import com.jkx.common.util.FileUtils;
import com.jkx.service.impl.ExcelServiceImpl;
import com.jkx.service.impl.StudentInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ${zhang}
 * @since 2020-09-17
 */

@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {

    @Autowired
    StudentInfoServiceImpl studentService;

    @Autowired
    ExcelServiceImpl excelService;

    @GetMapping("/list")
    public DataResult getSome() {
        List<Map<String, String>> studentInfo = studentService.getAll();
        int ok = 0;
        JSONObject jsonObject = new JSONObject();
        if (studentInfo != null) {
            ok = 1;
        }
        jsonObject.set("ok", ok);
        jsonObject.set("data", studentInfo);
        return DataResult.success(studentInfo);
    }

    @PostMapping("/insert")
    public DataResult insertStudentInfo(MultipartFile multipartFile) {
        // 类型转换
        File file = FileUtils.multipartFileToFile(multipartFile);
        // 解析excel
        List<Map<String, Object>> maps = excelService.parseExcel(file);
        // 得到数据库字段映射
        Map<String, String> excelMapper = excelService.getExcelMapper();

        // 插入数据库
        int i = studentService.saveAll(maps, excelMapper);
        if (i != 0) {
            return DataResult.success("插入成功");
        }
        return DataResult.error("插入失败");
//        return DataResult.error(0);

    }

    @GetMapping("/del")
    public DataResult delStudentInfo(int id) {
        int i = studentService.delStudentInfo(id);
        if (i != 0) {
            return DataResult.success("删除成功");
        }
        return DataResult.error();
    }

    @GetMapping("/saveOne")
    public DataResult saveOne() {
        return null;
    }

}

