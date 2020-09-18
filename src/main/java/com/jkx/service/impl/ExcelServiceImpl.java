package com.jkx.service.impl;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.jkx.dao.ExcelMapperDao;
import com.jkx.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExcelServiceImpl implements ExcelService {

    /**
     * 解析excel文件
     *
     * @param file
     * @return
     */
    @Override
    public List<Map<String, Object>> parseExcel(File file, Map<String, String> databaseType) {

        ExcelReader reader = ExcelUtil.getReader(file);
        List<Map<String, Object>> read = reader.readAll();
        List<Map<String, Object>> readAll = new ArrayList<>();
        // 关闭流操作
        reader.close();
        // 遍历map 把值为null的修改为""
        for (Map<String, Object> map : read) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() == null) {
                    map.put(entry.getKey(), "");
                }
                if (entry.getKey() == "") {
                    continue;
                }
                // 获取字段对应的类型
                // 如果是 java.util.Date 类型，并且没有值，就设置为当前日期
                System.out.println(entry.getKey());
                System.out.println(databaseType.get(entry.getKey()));
                if (databaseType.get(entry.getKey()).equals("java.util.Date")
                        && (entry.getValue() == null || entry.getValue() == "")) {
                    try {
                        Object obj = Class.forName(databaseType.get(entry.getKey())).newInstance();
                        String strDateFormat = "yyyy/MM/dd";
                        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
                        map.put(entry.getKey(), sdf.format(obj));
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
            // 过滤 key 为null的值
            map = map.entrySet().stream()
                    .filter((e) -> checkKey(e.getKey()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue
                    ));
            readAll.add(map);
        }

        return readAll;
    }

    private static boolean checkKey(String key) {
        if (key == "" || key.equals(" ")) {
            return false;
        }
        if (null == key) {
            return false;
        }
        return true;
    }

    @Autowired
    ExcelMapperDao mapperMapper;

    /**
     * 得到映射表
     *
     * @return
     */
    @Override
    public Map<String, String> getExcelMapper() {
        List<Map<String, String>> excelMapper = mapperMapper.getExcelMapper();
        Map<String, String> mapper = new HashMap<>(50);
        for (Map<String, String> map : excelMapper) {
            String excel_name = map.get("excel_name");
            String database_name = map.get("database_name");
            // 设置key - value
            mapper.put(excel_name, database_name);
        }
        return mapper;
    }

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
