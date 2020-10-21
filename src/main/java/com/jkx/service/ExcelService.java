package com.jkx.service;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * excel转换
 * @author Mr zhang
 */

public interface ExcelService {
    /**
     * 处理excel文件
     * @param file excel文件
     * @param databaseType 数据库类型
     * @return  list
     */
    List<Map<String, Object>> parseExcel(File file, Map<String, String> databaseType);

    /**
     * 得到映射表
     * @return excel
     */
    Map<String, String> getExcelMapper();

    /**
     * 查询excel字段对应的java类型
     * @return Map<col1, col2>
     */
    Map<String, String> getType();

}
