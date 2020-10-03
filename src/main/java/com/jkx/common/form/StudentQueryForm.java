package com.jkx.common.form;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 条件查询表单
 * @author zxq
 */
@Data
@EqualsAndHashCode
public class StudentQueryForm implements Serializable {

    private static final long serialVersionUID = 78283478238783L;

    /**
     * 学号
     */
    private String studentId;
    /**
     * 姓名
     */
    private String studentName;
    /**
     * 性别
     */
    private String gender;
    /**
     * 系部
     */
    private String department;
    /**
     * 班级
     */
    private String stuClass;
    /**
     * 民族
     */
    private String nation;
    /**
     * 政治面貌
     */
    private String politics;
    /**
     * 户口性质
     */
    private String residentType;
    /**
     * 是否贷款
     */
    private String isLoan;



}
