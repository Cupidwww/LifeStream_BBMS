package com.entity.vo;

import com.entity.XuekuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 血库信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public class XuekuxinxiVO  implements Serializable {
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
	 * 备注
	 */
	
	private String beizhu;
				
	
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
			
}