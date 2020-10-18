package com.jkx.common.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 处理excel数据，由serviceImpl调用
 * @author lx
 */
public class ExcelTypeUtils {

    /**
     * 遍历map 处理学生的信息
     * @param map 传入的学生信息
     * @param databaseType 数据库类型对应的Java类型
     * @return map
     */
    public static Map<String, Object> filter(Map<String, Object> map,
                                      Map<String, String> databaseType){
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                map.put(entry.getKey(), "");
            }
            if ("".equals(entry.getKey())) {
                continue;
            }
            // 获取字段对应的类型
            // 如果是 java.util.Date 类型，并且没有值，就设置为当前日期
            boolean judgeTime = "java.util.Date".equals(databaseType.get(entry.getKey()))
                    && StringUtils.isBlank((CharSequence) entry.getValue());
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
