package com.jkx.controller;

import com.jkx.common.util.Res;
import com.jkx.config.ColumnsConfig;
import com.jkx.service.impl.ModDatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Mr zhang
 */
@RestController
@RequestMapping("/mod-database")
public class ModDatabaseController {

    @Autowired
    ModDatabaseServiceImpl modDatabaseService;

    @Autowired
    ColumnsConfig columnsConfig;

    /**
     * 给数据库添加字段
     * @param colName     列名
     * @param colType     sql类型
     * @param colNum      字段长度
     * @param colComment  sql注释
     * @return Res
     */
    @GetMapping("/add")
    public Res addColumn(String excelName, String colName, String colType,
                         String colNum, String colComment) {
        // 获取字段对应的java类型
        Map<String, String> columnJavaType = columnsConfig.getColumnJavaType();
        String colJavaType = columnJavaType.get(colName);
        // 获取数据库类型
        Map<String, String> columnDatabaseType = columnsConfig.getColumnDatabaseType();
        String databaseType = columnDatabaseType.get(colType);
        // 获取是否需要大小
        Map<String, Boolean> sizeRequired = columnsConfig.getSizeRequired();
        Boolean required = sizeRequired.get(colType);
        // 获取对象默认值
        Map<String, Object> columnDefault = columnsConfig.getColumnDefault();
        Object o = columnDefault.get(colType);

        int i = modDatabaseService.addCol(colName, databaseType, colNum, colComment,
                excelName, colJavaType, required, o);
        if (i != 0) {
            return Res.ok("添加字段成功");
        }
        return Res.error("添加字段失败");
    }

    /**
     * 删除数据库字段
     * @param colName 数据库字段名
     * @return Res
     */
    @GetMapping("/del")
    public Res addColumn(String colName) {
        int i = modDatabaseService.deleteCol(colName);
        return i != 0 ? Res.ok("删除字段成功") : Res.error(500, "删除字段失败");
    }

    /**
     * 查看数据库所有的字段
     * @return Res
     */
    @GetMapping("list")
    public Res listColum(){
        List<Map<String, String>> maps = modDatabaseService.listColumn();
        return maps != null ?  Res.ok(maps) : Res.error("查询失败");
    }

}
