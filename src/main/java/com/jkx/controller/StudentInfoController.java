package com.jkx.controller;


import cn.hutool.json.JSONObject;
import com.jkx.common.util.FileUtils;
import com.jkx.common.util.Res;
import com.jkx.service.impl.ExcelServiceImpl;
import com.jkx.service.impl.StudentInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

/**
 *
 * @author ${zhang}
 * @since 2020-09-17
 */

@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {

    @Autowired
    StudentInfoServiceImpl studentService;

    /**
     * 获取所有学生信息
     * @return
     */
    @Autowired
    ExcelServiceImpl excelService;

    @GetMapping("/list")
    public Res getSome() {
        List<Map<String, String>> studentInfo = studentService.getAll();
        int ok = 0;
        JSONObject jsonObject = new JSONObject();
        if (studentInfo != null) {
            ok = 1;
        }
        jsonObject.set("ok", ok);
        jsonObject.set("data", studentInfo);
        return Res.ok(studentInfo);
    }

    /**
     * 从excel取出数据，批量插入数据库
     * @param multipartFile 文件
     * @return
     */
    @PostMapping("/insert")
    public Res insertStudentInfo(MultipartFile multipartFile) {
        // 类型转换
        File file = FileUtils.multipartFileToFile(multipartFile);
        // 获取数据库字段名对应java的类型映射
        Map<String, String> databaseType = excelService.getType();
        // 解析excel
        List<Map<String, Object>> maps = excelService.parseExcel(file, databaseType);
        // 得到数据库字段映射
        Map<String, String> excelMapper = excelService.getExcelMapper();

        // 插入数据库
        int i = studentService.saveAll(maps, excelMapper);
        if (i != 0) {
            return Res.ok("插入成功");
        }
        return Res.error(500,"插入失败");
    }

    /**
     * 删除一个学生信息
     * @param id 学生id
     * @return
     */
    @GetMapping("/del/{id}")
    public Res delStudentInfo(@PathVariable Integer id) {
        int i = studentService.delStudentInfo(id);
        if (i != 0) {
            return Res.ok("删除成功");
        }
        return Res.error();
    }

    /**
     * 批量删除学生信息
     * @param ids 学生id集合
     * @return
     */
    @RequestMapping("/del")
    public Res delSomeStudent(@RequestBody List<String> ids){
        System.out.println("ssss");
        int i = studentService.delSomeStudentInfo(ids);
        if (i != 0) {
            return Res.ok("删除成功");
        }
        return Res.error(500, "删除失败");

    }

    /**
     * 保存一个学生
     * @param map 学生信息
     * @return
     */
    @RequestMapping("/insertOne")
    public Res saveOne(@RequestBody Map<String, Object> map) {

        // 得到数据库字段映射
        Map<String, String> excelMapper = excelService.getExcelMapper();

        // 获取数据库字段名对应java的类型映射
        Map<String, String> databaseType = excelService.getType();

        int i = studentService.saveOne(map, excelMapper, databaseType);
        if (i!=0){
            return Res.ok("添加成功");
        }
        return Res.error();
    }

}

