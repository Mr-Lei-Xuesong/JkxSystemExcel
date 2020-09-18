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
 * <p>
 * 
 * </p>
 *
 * @author ${author}
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
    private Integer Id;

    /**
     * 账户
     */
    @TableField("Account")
    private String Account;

    /**
     * 密码
     */
    @TableField("Password")
    private String Password;

    /**
     * 真名
     */
    @TableField("RealName")
    private String RealName;

    /**
     * 性别
     */
    @TableField("Gender")
    private String Gender;

    /**
     * 电话
     */
    @TableField("Tel")
    private String Tel;

    /**
     * 邮箱
     */
    @TableField("Email")
    private String Email;

    /**
     * 部门
     */
    @TableField("Department")
    private String Department;

    /**
     * 描述
     */
    @TableField("Description")
    private String Description;

    /**
     * 上次登录
     */
    @TableField("PreviousVisit")
    private LocalDate PreviousVisit;

    /**
     * 最后登录
     */
    @TableField("LastVisit")
    private LocalDate LastVisit;

    /**
     * 创建时间
     */
    @TableField("CreateDate")
    private LocalDate CreateDate;

    /**
     * 创建用户
     */
    @TableField("CreateUser")
    private String CreateUser;

    /**
     * 修改时间
     */
    @TableField("ModifyDate")
    private LocalDate ModifyDate;

    /**
     * 修改用户
     */
    @TableField("ModifyUser")
    private String ModifyUser;


}
