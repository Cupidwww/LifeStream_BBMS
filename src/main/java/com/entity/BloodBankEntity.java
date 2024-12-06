package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import com.baomidou.mybatisplus.annotations.TableField;

/**
 * 血库管理实体类
 */
@TableName("blood_bank_management")
public class BloodBankEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId
    private Long id;

    /**
     * 血型
     */
    @TableField("bloodType")
    private String bloodType;

    /**
     * 血液种类
     */
    @TableField("bloodCategory")
    private String bloodCategory;

    /**
     * 血量
     */
    @TableField("bloodVolume")
    private Float bloodVolume;

    /**
     * 入库日期
     */
    @TableField("transaction_date")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date transactionDate;

    /**
     * 过期日期
     */
    @TableField("expiration_date")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date expirationDate;

    /**
     * 血液来源（外键）
     */
    @TableField("bloodSource")
    private String bloodSource;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    /**
     * 获取主键id
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取血型
     * @return 血型
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * 设置血型
     * @param bloodType 血型
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * 获取血液种类
     * @return 血液种类
     */
    public String getBloodCategory() {
        return bloodCategory;
    }

    /**
     * 设置血液种类
     * @param bloodCategory 血液种类
     */
    public void setBloodCategory(String bloodCategory) {
        this.bloodCategory = bloodCategory;
    }

    /**
     * 获取血量
     * @return 血量
     */
    public Float getBloodVolume() {
        return bloodVolume;
    }

    /**
     * 设置血量
     * @param bloodVolume 血量
     */
    public void setBloodVolume(Float bloodVolume) {
        this.bloodVolume = bloodVolume;
    }

    /**
     * 获取入库日期
     * @return 入库日期
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * 设置入库日期
     * @param transactionDate 入库日期
     */
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * 获取过期日期
     * @return 过期日期
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * 设置过期日期
     * @param expirationDate 过期日期
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * 获取血液来源
     * @return 血液来源
     */
    public String getBloodSource() {
        return bloodSource;
    }

    /**
     * 设置血液来源
     * @param bloodSource 血液来源
     */
    public void setBloodSource(String bloodSource) {
        this.bloodSource = bloodSource;
    }

    /**
     * 获取备注
     * @return 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取添加时间
     * @return 添加时间
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * 设置添加时间
     * @param addtime 添加时间
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
} 