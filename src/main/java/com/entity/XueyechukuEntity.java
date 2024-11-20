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


/**
 * 血液出库
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
@TableName("xueyechuku")
public class XueyechukuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XueyechukuEntity() {
		
	}
	
	public XueyechukuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 血库编号
	 */
					
	private String xuekubianhao;
	
	/**
	 * 血型
	 */
					
	private String xuexing;
	
	/**
	 * 血液种类
	 */
					
	private String xueyezhonglei;
	
	/**
	 * 袋数
	 */
					
	private Integer daishu;
	
	/**
	 * 血量
	 */
					
	private Float xueliang;
	
	/**
	 * 出库日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date chukuriqi;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	/**
	 * 工号
	 */
					
	private String gonghao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：血库编号
	 */
	public void setXuekubianhao(String xuekubianhao) {
		this.xuekubianhao = xuekubianhao;
	}
	/**
	 * 获取：血库编号
	 */
	public String getXuekubianhao() {
		return xuekubianhao;
	}
	/**
	 * 设置：血型
	 */
	public void setXuexing(String xuexing) {
		this.xuexing = xuexing;
	}
	/**
	 * 获取：血型
	 */
	public String getXuexing() {
		return xuexing;
	}
	/**
	 * 设置：血液种类
	 */
	public void setXueyezhonglei(String xueyezhonglei) {
		this.xueyezhonglei = xueyezhonglei;
	}
	/**
	 * 获取：血液种类
	 */
	public String getXueyezhonglei() {
		return xueyezhonglei;
	}
	/**
	 * 设置：袋数
	 */
	public void setDaishu(Integer daishu) {
		this.daishu = daishu;
	}
	/**
	 * 获取：袋数
	 */
	public Integer getDaishu() {
		return daishu;
	}
	/**
	 * 设置：血量
	 */
	public void setXueliang(Float xueliang) {
		this.xueliang = xueliang;
	}
	/**
	 * 获取：血量
	 */
	public Float getXueliang() {
		return xueliang;
	}
	/**
	 * 设置：出库日期
	 */
	public void setChukuriqi(Date chukuriqi) {
		this.chukuriqi = chukuriqi;
	}
	/**
	 * 获取：出库日期
	 */
	public Date getChukuriqi() {
		return chukuriqi;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
	/**
	 * 设置：工号
	 */
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	/**
	 * 获取：工号
	 */
	public String getGonghao() {
		return gonghao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}

}
