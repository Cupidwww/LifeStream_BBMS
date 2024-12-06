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
 * 体检信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
@TableName("tijianxinxi")
public class TijianxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TijianxinxiEntity() {
		
	}
	
	public TijianxinxiEntity(T t) {
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
	 * 献血编号
	 */
					
	private String xianxuebianhao;
	
	/**
	 * 献血姓名
	 */
					
	private String xianxuexingming;
	
	/**
	 * 体重
	 */
					
	private String tizhong;
	
	/**
	 * 脉搏
	 */
					
	private String maibo;
	
	/**
	 * 皮肤病
	 */
					
	private String pifubing;
	
	/**
	 * 四肢缺失
	 */
					
	private String sizhiqueshi;
	
	/**
	 * 体检时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date tijianshijian;
	
	/**
	 * 体检结果
	 */
					
	private String tijianjieguo;
	
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
	 * 设置：献血编号
	 */
	public void setXianxuebianhao(String xianxuebianhao) {
		this.xianxuebianhao = xianxuebianhao;
	}
	/**
	 * 获取：献血编号
	 */
	public String getXianxuebianhao() {
		return xianxuebianhao;
	}
	/**
	 * 设置：献血姓名
	 */
	public void setXianxuexingming(String xianxuexingming) {
		this.xianxuexingming = xianxuexingming;
	}
	/**
	 * 获取：献血姓名
	 */
	public String getXianxuexingming() {
		return xianxuexingming;
	}
	/**
	 * 设置：体重
	 */
	public void setTizhong(String tizhong) {
		this.tizhong = tizhong;
	}
	/**
	 * 获取：体重
	 */
	public String getTizhong() {
		return tizhong;
	}
	/**
	 * 设置：脉搏
	 */
	public void setMaibo(String maibo) {
		this.maibo = maibo;
	}
	/**
	 * 获取：脉搏
	 */
	public String getMaibo() {
		return maibo;
	}
	/**
	 * 设置：皮肤病
	 */
	public void setPifubing(String pifubing) {
		this.pifubing = pifubing;
	}
	/**
	 * 获取：皮肤病
	 */
	public String getPifubing() {
		return pifubing;
	}
	/**
	 * 设置：四肢缺失
	 */
	public void setSizhiqueshi(String sizhiqueshi) {
		this.sizhiqueshi = sizhiqueshi;
	}
	/**
	 * 获取：四肢缺失
	 */
	public String getSizhiqueshi() {
		return sizhiqueshi;
	}
	/**
	 * 设置：体检时间
	 */
	public void setTijianshijian(Date tijianshijian) {
		this.tijianshijian = tijianshijian;
	}
	/**
	 * 获取：体检时间
	 */
	public Date getTijianshijian() {
		return tijianshijian;
	}
	/**
	 * 设置：体检结果
	 */
	public void setTijianjieguo(String tijianjieguo) {
		this.tijianjieguo = tijianjieguo;
	}
	/**
	 * 获取：体检结果
	 */
	public String getTijianjieguo() {
		return tijianjieguo;
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
