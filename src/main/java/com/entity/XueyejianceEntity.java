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
 * 血液检测
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
@TableName("xueyejiance")
public class XueyejianceEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XueyejianceEntity() {
		
	}
	
	public XueyejianceEntity(T t) {
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
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 试管编号
	 */
					
	private String shiguanbianhao;
	
	/**
	 * 血型
	 */
					
	private String xuexing;
	
	/**
	 * 乙肝
	 */
					
	private String yigan;
	
	/**
	 * hiv
	 */
					
	private String hiv;
	
	/**
	 * 梅毒
	 */
					
	private String meidu;
	
	/**
	 * 检测结果
	 */
					
	private String jiancejieguo;
	
	/**
	 * 检测时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jianceshijian;
	
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
	 * 设置：试管编号
	 */
	public void setShiguanbianhao(String shiguanbianhao) {
		this.shiguanbianhao = shiguanbianhao;
	}
	/**
	 * 获取：试管编号
	 */
	public String getShiguanbianhao() {
		return shiguanbianhao;
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
	 * 设置：乙肝
	 */
	public void setYigan(String yigan) {
		this.yigan = yigan;
	}
	/**
	 * 获取：乙肝
	 */
	public String getYigan() {
		return yigan;
	}
	/**
	 * 设置：hiv
	 */
	public void setHiv(String hiv) {
		this.hiv = hiv;
	}
	/**
	 * 获取：hiv
	 */
	public String getHiv() {
		return hiv;
	}
	/**
	 * 设置：梅毒
	 */
	public void setMeidu(String meidu) {
		this.meidu = meidu;
	}
	/**
	 * 获取：梅毒
	 */
	public String getMeidu() {
		return meidu;
	}
	/**
	 * 设置：检测结果
	 */
	public void setJiancejieguo(String jiancejieguo) {
		this.jiancejieguo = jiancejieguo;
	}
	/**
	 * 获取：检测结果
	 */
	public String getJiancejieguo() {
		return jiancejieguo;
	}
	/**
	 * 设置：检测时间
	 */
	public void setJianceshijian(Date jianceshijian) {
		this.jianceshijian = jianceshijian;
	}
	/**
	 * 获取：检测时间
	 */
	public Date getJianceshijian() {
		return jianceshijian;
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