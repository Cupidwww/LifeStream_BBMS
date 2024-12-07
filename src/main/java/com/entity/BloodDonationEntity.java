package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;


/**
 * 献血登记
 * 数据库通用操作实体类（普通增删改查）
 * @author
 * @email
 * @date 2023-03-17 10:40:32
 */
@TableName("blood_donation")
public class BloodDonationEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public BloodDonationEntity() {

    }

    public BloodDonationEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @TableId
    private Long id;

    @TableField("bloodType")
    private String bloodType;

    @TableField("bloodCategory")
    private String bloodCategory;

    @TableField("bloodBagNumber")
    private String bloodBagNumber;

    @TableField("bloodVolume")
    private String bloodVolume;

    @TableField("isQualified")
    private String isQualified;

    @TableField("registrationDate")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date registrationDate;

    @TableField("donorID")
    private Long donorID;

    @TableField("staffID")
    private Long staffID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodCategory(String bloodCategory) {
        this.bloodCategory = bloodCategory;
    }

    public String getBloodCategory() {
        return bloodCategory;
    }

    public void setBloodBagNumber(String bloodBagNumber) {
        this.bloodBagNumber = bloodBagNumber;
    }

    public String getBloodBagNumber() {
        return bloodBagNumber;
    }

    public void setBloodVolume(String bloodVolume) {
        this.bloodVolume = bloodVolume;
    }

    public String getBloodVolume() {
        return bloodVolume;
    }

    public void setIsQualified(String isQualified) {
        this.isQualified = isQualified;
    }

    public String getIsQualified() {
        return isQualified;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setDonorID(Long donorID) {
        this.donorID = donorID;
    }

    public Long getDonorID() {
        return donorID;
    }

    public void setStaffID(Long staffID) {
        this.staffID = staffID;
    }

    public Long getStaffID() {
        return staffID;
    }
}
