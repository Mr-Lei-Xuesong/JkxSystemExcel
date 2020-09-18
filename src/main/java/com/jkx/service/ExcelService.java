package com.jkx.service;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface ExcelService {
    /**
     * 处理excel文件
     */
    List<Map<String, Object>> parseExcel(File file, Map<String, String> databaseType);

    /**
     *  得到excel数据库映射
     * @return
     */
    Map<String, String> getExcelMapper();

    /**
     * 查询excel字段对应的java类型
     * @return Map<col1, col2>
     */
    Map<String, String> getType();

}
