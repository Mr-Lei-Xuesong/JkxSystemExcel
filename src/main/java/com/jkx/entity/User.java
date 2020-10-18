package com.jkx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author zxq
 * @since 2020-09-17
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID主键
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账户
     */
    @TableField("Account")
    private String account;

    /**
     * 密码
     */
    @TableField("Password")
    private String password;

    /**
     * 真名
     */
    @TableField("RealName")
    private String realName;

    /**
     * 性别
     */
    @TableField("Gender")
    private String gender;

    /**
     * 电话
     */
    @TableField("Tel")
    private String tel;

    /**
     * 邮箱
     */
    @TableField("Email")
    private String email;

    /**
     * 部门
     */
    @TableField("Department")
    private String department;

    /**
     * 描述
     */
    @TableField("Description")
    private String description;

    /**
     * 上次登录
     */
    @TableField("PreviousVisit")
    private LocalDate previousVisit;

    /**
     * 最后登录
     */
    @TableField("LastVisit")
    private LocalDate lastVisit;

    /**
     * 创建时间
     */
    @TableField("CreateDate")
    private LocalDate createDate;

    /**
     * 创建用户
     */
    @TableField("CreateUser")
    private String createUser;

    /**
     * 修改时间
     */
    @TableField("ModifyDate")
    private LocalDate modifyDate;

    /**
     * 修改用户
     */
    @TableField("ModifyUser")
    private String modifyUser;


}
