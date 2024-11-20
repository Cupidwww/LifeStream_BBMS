package com.entity.vo;

import com.entity.TijianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 体检信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public class TijianxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
