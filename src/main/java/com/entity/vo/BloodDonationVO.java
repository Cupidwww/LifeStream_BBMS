package com.entity.vo;

import com.entity.BloodDonationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

public class BloodDonationVO {
    private static final long serialVersionUID = 1L;

    private String bloodType;

    private String bloodCategory;

    private String bloodBagNumber;

    private String bloodVolume;

    private String isQualified;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date registrationDate;

    private long donorID;

    private long staffID;

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

    public void setDonorID(long donorID) {
        this.donorID = donorID;
    }

    public long getDonorID() {
        return donorID;
    }

    public void setStaffID(long staffID) {
        this.staffID = staffID;
    }

    public long getStaffID() {
        return staffID;
    }
}
