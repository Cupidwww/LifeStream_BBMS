package com.entity.model;

import com.entity.BloodBankEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * 血库管理
 * 接收传参的实体类
 * 取自ModelAndView 的model名称
 * @author
 * @email
 * @date 2023-03-17 10:40:32
 */
public class BloodBankModel extends BloodBankEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 血型
     */
    private String bloodType;

    /**
     * 血液种类
     */
    private String bloodCategory;

    /**
     * 血量
     */
    private Float bloodVolume;

    /**
     * 入库日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date transactionDate;

    /**
     * 有效期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date expirationDate;

    /**
     * 血液来源
     */
    private String bloodSource;

    /**
     * 备注
     */
    private String remarks;

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodCategory() {
        return bloodCategory;
    }

    public void setBloodCategory(String bloodCategory) {
        this.bloodCategory = bloodCategory;
    }

    public Float getBloodVolume() {
        return bloodVolume;
    }

    public void setBloodVolume(Float bloodVolume) {
        this.bloodVolume = bloodVolume;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBloodSource() {
        return bloodSource;
    }

    public void setBloodSource(String bloodSource) {
        this.bloodSource = bloodSource;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}