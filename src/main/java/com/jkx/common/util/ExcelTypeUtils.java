package com.jkx.common.util;

import java.sql.Timestamp;
import java.util.Map;
import java.util.stream.Collectors;

public class ExcelTypeUtils {

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
            boolean judgeTime = databaseType.get(entry.getKey()).equals("java.sql.Timestamp")
                    && (entry.getValue() == null || entry.getValue() == "");
            if (judgeTime) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                map.put(entry.getKey(), timestamp);
            }
        }
        // 过滤 key 为null的值
        map = map.entrySet().stream()
                .filter((e) -> checkKey(e.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

        return map;
    }

    private static boolean checkKey(String key) {
        if (key == "" || " ".equals(key) || null == key) {
            return false;
        }
//        if (null == key) {
//            return false;
//        }
        return true;
    }
}
