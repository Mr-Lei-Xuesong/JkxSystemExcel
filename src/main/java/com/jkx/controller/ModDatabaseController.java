package com.jkx.controller;

import com.jkx.common.util.Res;
import com.jkx.service.impl.ModDatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr zhang
 */

@RestController
@RequestMapping("/modDatabase")
public class ModDatabaseController {

    @Autowired
    ModDatabaseServiceImpl modDatabaseService;

    /**
     * @param colName     列名
     * @param colType     sql类型
     * @param colNum      字段长度
     * @param colComment  sql注释
     * @param colJavaType 对应的java类型(前段做选择器，写全名)
     * @return
     */
    @GetMapping("/add")
    public Res addColumn(String excelName,
                         String colName,
                         String colType,
                         String colNum,
                         String colComment,
                         String colJavaType) {

        int i = modDatabaseService.addCol(colName, colType, colNum, colComment, excelName, colJavaType);

        if (i != 0) {
            return Res.ok("添加字段成功");
        }
        return Res.error("添加字段失败");
    }

    @GetMapping("/del")
    public Res addColumn(String colName) {
        int i = modDatabaseService.deleteCol(colName);
        if (i != 0) {
            return Res.ok("删除字段成功");
        }
        return Res.error(500, "删除字段失败");
    }


}
