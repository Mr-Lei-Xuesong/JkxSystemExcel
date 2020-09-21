package com.jkx;

import com.jkx.config.ColumnsConfig;
import com.jkx.dao.IUsersDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@SpringBootTest
public class UserDaoTest {
    @Autowired
    IUsersDao usersDao;

    @Autowired
    ColumnsConfig columnsConfig;

    @Test
    void findByAccount(){
        System.out.println(columnsConfig.getColumnDefault());
//        Date date = new Date();
//        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
//        Date d= new Date();
//        String str = sdf.format(d);
//        System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss SSS 格式化后的输出: "+s
//        System.out.println(date);
//        Date date = new Date();
//        try {
//            Object o = Class.forName("java.util.Date").newInstance();
//            System.out.println(o);
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
