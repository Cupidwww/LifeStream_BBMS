package com.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class HealthManagementVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long staffID;

    private Long donorID;

    private String gender;

    private String weight;

    private String height;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date physicalExamTime;

    private String physicalExamResult;

    private String testTubeNumber;

    private String bloodType;

    private String hepatitisB;

    private String hiv;

    private String syphilis;

    private String testResult;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date testTime;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
