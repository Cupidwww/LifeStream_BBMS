package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("health_management")
public class HealthManagementEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public HealthManagementEntity() {

    }

    public HealthManagementEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @TableId
    private Long id;

    @TableField("staffID")
    private Long staffID;

    @TableField("donorID")
    private Long donorID;

    @TableField("gender")
    private String gender;

    @TableField("weight")
    private String weight;

    @TableField("height")
    private String height;

    @TableField("physicalExamTime")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date physicalExamTime;

    @TableField("physicalExamResult")
    private String physicalExamResult;

    @TableField("testTubeNumber")
    private String testTubeNumber;

    @TableField("bloodType")
    private String bloodType;

    @TableField("hepatitisB")
    private String hepatitisB;

    @TableField("hiv")
    private String hiv;

    @TableField("syphilis")
    private String syphilis;

    @TableField("testResult")
    private String testResult;

    @TableField("testTime")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date testTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStaffID(Long staffID) {
        this.staffID = staffID;
    }

    public Long getStaffID() {
        return staffID;
    }

    public void setDonorID(Long donorID) {
        this.donorID = donorID;
    }

    public Long getDonorID() {
        return donorID;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHeight() {
        return height;
    }

    public void setPhysicalExamTime(Date physicalExamTime) {
        this.physicalExamTime = physicalExamTime;
    }

    public Date getPhysicalExamTime() {
        return physicalExamTime;
    }

    public void setPhysicalExamResult(String physicalExamResult) {
        this.physicalExamResult = physicalExamResult;
    }

    public String getPhysicalExamResult() {
        return physicalExamResult;
    }

    public void setTestTubeNumber(String testTubeNumber) {
        this.testTubeNumber = testTubeNumber;
    }

    public String getTestTubeNumber() {
        return testTubeNumber;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setHepatitisB(String hepatitisB) {
        this.hepatitisB = hepatitisB;
    }

    public String getHepatitisB() {
        return hepatitisB;
    }

    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    public String getHiv() {
        return hiv;
    }

    public void setSyphilis(String syphilis) {
        this.syphilis = syphilis;
    }

    public String getSyphilis() {
        return syphilis;
    }

    public void setTestResult(String hiv) {
        this.testResult = testResult;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    public Date getTestTime() {
        return testTime;
    }
}
