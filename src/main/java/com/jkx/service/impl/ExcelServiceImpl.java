package com.jkx.service.impl;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.jkx.common.util.ExcelTypeUtils;
import com.jkx.dao.ExcelMapperDao;
import com.jkx.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

/**
 * @author zxp
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    /**
     * 解析excel文件
     * @param file excel文件
     * @return 返回学生集合
     */
    @Override
    public List<Map<String, Object>> parseExcel(File file, Map<String, String> databaseType) {

        // 解析excel数据
        ExcelReader reader = ExcelUtil.getReader(file);
        List<Map<String, Object>> read = reader.readAll();
        List<Map<String, Object>> readAll = new ArrayList<>();
        // 关闭流操作
        reader.close();
        // 遍历map 把值为null的修改为""
        for (Map<String, Object> map : read) {
            Map<String, Object> filter = ExcelTypeUtils.filter(map, databaseType);
            readAll.add(filter);
        }
        return readAll;
    }



    @Autowired
    ExcelMapperDao mapperMapper;

    /**
     * 得到映射表
     * @return excel列与数据库列的对应关系
     */
    @Override
    public Map<String, String> getExcelMapper() {
        List<Map<String, String>> excelMapper = mapperMapper.getExcelMapper();
        Map<String, String> mapper = new HashMap<>(50);
        for (Map<String, String> map : excelMapper) {
            String excelName = map.get("excel_name");
            String databaseName = map.get("database_name");
            // 设置key - value
            mapper.put(excelName, databaseName);
        }
        return mapper;
    }

    /**
     * 获取数据库中 excel字段对应的java类型
     *
     * @return 获取excel列对应的Java类型
     */
    @Override
    public Map<String, String> getType() {
        List<Map<String, String>> type = mapperMapper.getType();
        Map<String, String> map = new HashMap<>(50);
        for (Map<String, String> m : type) {
            // 设置key - value
            map.put(m.get("excel_name"), m.get("type"));
        }
        return map;
    }
}
