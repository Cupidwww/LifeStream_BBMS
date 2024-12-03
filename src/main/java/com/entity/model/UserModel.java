package com.entity.model;

import com.entity.UserEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * 用户
 * 接收传参的实体类
 * 取自ModelAndView 的model名称
 * @author
 * @email
 * @date 2023-03-17 10:15:15
 */
public class UserModel extends UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 获取：用户名
     */
    public String getUsername() {
        return super.getUsername();
    }

    /**
     * 设置：用户名
     */
    public void setUsername(String username) {
        super.setUsername(username);
    }

    /**
     * 获取：密码
     */
    public String getPassword() {
        return super.getPassword();
    }

    /**
     * 设置：密码
     */
    public void setPassword(String password) {
        super.setPassword(password);
    }

    /**
     * 获取：用户角色
     */
    public String getRole() {
        return super.getRole();
    }

    /**
     * 设置：用户角色
     */
    public void setRole(String role) {
        super.setRole(role);
    }

    /**
     * 获取：员工工号
     */
    public String getEmployeeNumber() {
        return super.getEmployeeNumber();
    }

    /**
     * 设置：员工工号
     */
    public void setEmployeeNumber(String employeeNumber) {
        super.setEmployeeNumber(employeeNumber);
    }

    /**
     * 获取：姓名
     */
    public String getName() {
        return super.getName();
    }

    /**
     * 设置：姓名
     */
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * 获取：性别
     */
    public String getGender() {
        return super.getGender();
    }

    /**
     * 设置：性别
     */
    public void setGender(String gender) {
        super.setGender(gender);
    }

    /**
     * 获取：年龄
     */
    public Integer getAge() {
        return super.getAge();
    }

    /**
     * 设置：年龄
     */
    public void setAge(Integer age) {
        super.setAge(age);
    }

    /**
     * 获取：联系电话
     */
    public String getPhone() {
        return super.getPhone();
    }

    /**
     * 设置：联系电话
     */
    public void setPhone(String phone) {
        super.setPhone(phone);
    }

    /**
     * 获取：邮箱
     */
    public String getEmail() {
        return super.getEmail();
    }

    /**
     * 设置：邮箱
     */
    public void setEmail(String email) {
        super.setEmail(email);
    }

    /**
     * 获取：身份证号码
     */
    public String getIdCard() {
        return super.getIdCard();
    }

    /**
     * 设置：身份证号码
     */
    public void setIdCard(String idCard) {
        super.setIdCard(idCard);
    }

    /**
     * 获取：家庭住址
     */
    public String getHomeAddress() {
        return super.getHomeAddress();
    }

    /**
     * 设置：家庭住址
     */
    public void setHomeAddress(String homeAddress) {
        super.setHomeAddress(homeAddress);
    }

    /**
     * 获取：头像
     */
    public String getAvatar() {
        return super.getAvatar();
    }

    /**
     * 设置：头像
     */
    public void setAvatar(String avatar) {
        super.setAvatar(avatar);
    }
}