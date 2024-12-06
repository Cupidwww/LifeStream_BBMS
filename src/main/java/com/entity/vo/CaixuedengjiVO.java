package com.entity.vo;

import com.entity.CaixuedengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 采血登记
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public class CaixuedengjiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 献血姓名
	 */
	
	private String xianxuexingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 血袋编号
	 */
	
	private String xuedaibianhao;
		
	/**
	 * 血液种类
	 */
	
	private String xueyezhonglei;
		
	/**
	 * 血型
	 */
	
	private String xuexing;
		
	/**
	 * 血量
	 */
	
	private String xueliang;
		
	/**
	 * 是否合格
	 */
	
	private String shifouhege;
		
	/**
	 * 登记日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjiriqi;
		
	/**
	 * 工号
	 */
	
	private String gonghao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
				
	
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
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：血袋编号
	 */
	 
	public void setXuedaibianhao(String xuedaibianhao) {
		this.xuedaibianhao = xuedaibianhao;
	}
	
	/**
	 * 获取：血袋编号
	 */
	public String getXuedaibianhao() {
		return xuedaibianhao;
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
	 * 设置：血量
	 */
	 
	public void setXueliang(String xueliang) {
		this.xueliang = xueliang;
	}
	
	/**
	 * 获取：血量
	 */
	public String getXueliang() {
		return xueliang;
	}
				
	
	/**
	 * 设置：是否合格
	 */
	 
	public void setShifouhege(String shifouhege) {
		this.shifouhege = shifouhege;
	}
	
	/**
	 * 获取：是否合格
	 */
	public String getShifouhege() {
		return shifouhege;
	}
				
	
	/**
	 * 设置：登记日期
	 */
	 
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
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
