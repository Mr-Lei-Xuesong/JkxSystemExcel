package com.jkx;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.jkx.service.impl.ExcelServiceImpl;
import com.jkx.service.impl.StudentInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class JkxSystemExcelApplicationTests {

    @Autowired
    StudentInfoServiceImpl studentService;
    @Autowired
    ExcelServiceImpl excelService;

    @Test
    void contextLoads() {

        ExcelReader reader = ExcelUtil.getReader(new File("D:\\Desktop\\jkx\\JkxSystem\\JkxSystem\\JkxSystemExcel\\计科系信息系统模板.xlsx"));
        List<Map<String, Object>> readAll = reader.readAll();
        // 关闭流操作
        reader.close();
        for (Map<String, Object> map : readAll) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                System.out.println("key=" + entry.getKey() + "\tvalue=" + entry.getValue());
                if (entry.getValue() == null) {
                    map.put(entry.getKey(), "");
                }
            }
            map = map.entrySet().stream()
                    .filter((e) -> checkKey(e.getKey()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue
                    ));
        }
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

    @Test
    void testType() {
        try {
            Object obj = Class.forName("java.util.Date").newInstance();
            String strDateFormat = "yyyy/MM/dd";
            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            System.out.println(sdf.format(obj));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testClassType() {
        Map<String, String> type = excelService.getType();
        System.out.println(type);
    }

}
