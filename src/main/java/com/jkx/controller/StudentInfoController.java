package com.jkx.controller;

import cn.hutool.json.JSONObject;
import com.jkx.common.annotation.Admin;
import com.jkx.common.annotation.TokenRequired;
import com.jkx.common.form.StudentQueryForm;
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
 * @author zhang
 * @since 2020-09-17
 */
@RestController
@RequestMapping("/student-info")
@TokenRequired
public class StudentInfoController {

    @Autowired
    StudentInfoServiceImpl studentService;

    @Autowired
    ExcelServiceImpl excelService;

    /**
     * 获取所有学生信息
     * @return res
     */
    @GetMapping("/list")
    public Res getSome() {
        List<Map<String, String>> studentInfo = studentService.getAll();
        return Res.ok(studentInfo);
    }

    /**
     * 查询学生信息，通过id
     * @param id 学生id
     * @return Res
     */
    @GetMapping("/queryById")
    public Res queryById(@RequestParam("id") String id){
        Map<String, String> studentInfo = studentService.queryById(id);
        return Res.ok(studentInfo);
    }

    /**
     * 多条件查询
     * @param stu 查询条件表单
     * @return Res
     */
    @GetMapping("/query")
    public Res mulQuery(@RequestParam("stu-info") String stu) {
        JSONObject from = new JSONObject(stu);
        StudentQueryForm studentQueryForm = new StudentQueryForm();
        studentQueryForm.setGender((String) from.get("gender"));
        studentQueryForm.setDepartment((String) from.get("department"));
        studentQueryForm.setIsLoan((String) from.get("isLoan"));
        studentQueryForm.setNation((String) from.get("nation"));
        studentQueryForm.setPolitics((String) from.get("politics"));
        studentQueryForm.setResidentType((String) from.get("residentType"));
        studentQueryForm.setStuClass((String) from.get("stuClass"));
        studentQueryForm.setStudentId((String) from.get("studentNum"));
        studentQueryForm.setStudentName((String) from.get("studentName"));
        List<Map<String, String>> maps = studentService.mulQuery(studentQueryForm);
        if (maps.isEmpty()) {
            return Res.error("未找到数据");
        }
        return Res.ok(maps);
    }


    /**
     * 根据字段名导出数据
     * @param colName 字段名列表
     * @return Res
     */
    @GetMapping("/download")
    public Res findStudentByCondition(@RequestBody List<String> colName) {
        List<Map<String, String>> maps = studentService.downByColName(colName);
        if (maps.isEmpty()) {
            return Res.error();
        } else {
            return Res.ok(maps);
        }
    }

    /**
     * 从excel取出数据，批量插入数据库
     * @param multipartFile 文件
     * @return res
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
     * @return res
     */
    @Admin
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
     * @return res
     */
    @Admin
    @RequestMapping("/del")
    public Res delSomeStudent(@RequestBody List<String> ids){
        int i = studentService.delSomeStudentInfo(ids);
        if (i != 0) {
            return Res.ok("删除成功");
        }
        return Res.error(500, "删除失败");

    }

    /**
     * 保存一个学生
     * @param map 学生信息
     * @return res
     */
    @Admin
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

    /**
     * 修改学生信息
     * @return Res
     */
    @PostMapping("/update")
    public Res updateStudentInfo(@RequestBody String stu){
        JSONObject jsonObject = new JSONObject(stu);
        if (jsonObject.size() == 1){
            return Res.ok("你还没有选择字段", null);
        } else {
            for (int i = 0; i < jsonObject.size(); i++) {
                for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                    if (!"Id".equals(entry.getKey())
                            && "".equals(entry.getValue().toString())) {
                        return Res.error("修改参数不能为空");
                    }
                }
            }
        }
        int i = studentService.updateStudentInfo(jsonObject);
        if (i != 0) {
            return Res.ok("修改成功", null);
        }
        return Res.error("修改失败");
    }
}

