package com.entity.model;

import com.entity.XueyechukuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 血液出库
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public class XueyechukuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
