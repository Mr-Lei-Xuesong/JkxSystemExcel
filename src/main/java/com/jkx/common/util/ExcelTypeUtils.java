package com.jkx.common.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class ExcelTypeUtils {

    /**
     * 遍历map 处理学生的信息
     * @param map
     * @param databaseType
     * @return
     */
    public static Map<String, Object> filter(Map<String, Object> map,
                                      Map<String, String> databaseType){
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                map.put(entry.getKey(), "");
            }
            if (entry.getKey() == "") {
                continue;
            }
            // 获取字段对应的类型
            // 如果是 java.sql.Timestamp 类型，并且没有值，就设置为当前日期
            boolean judgeTime = databaseType.get(entry.getKey()).equals("java.util.Date")
                    && (entry.getValue() == null || entry.getValue() == "");
            if (judgeTime) {
                LocalDate localDate = LocalDate.now();
                map.put(entry.getKey(), localDate);
            }
        }
        // 过滤 key 为null的值
        map = map.entrySet().stream()
                .filter((e) -> !StringUtils.isBlank(e.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

        return map;
    }
}
