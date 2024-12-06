package com.entity.vo;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.entity.UserEntity.Role;

/**
 * 用户视图对象
 * 用于返回给前端的用户数据,可能包含部分字段
 */
public class UserVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 用户角色
	 */
	private Role role;
	
	/**
	 * 员工工号
	 */
	private String employeeNumber;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private String gender;
	
	/**
	 * 年龄
	 */
	private Integer age;
	
	/**
	 * 联系电话
	 */
	private String phone;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 身份证号码
	 */
	private String idCard;
	
	/**
	 * 家庭住址
	 */
	private String homeAddress;
	
	/**
	 * 头像
	 */
	private String avatar;

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
	 * 获取用户名
	 * @return 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置用户名
	 * @param username 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取用户角色
	 * @return 用户角色
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * 设置用户角色
	 * @param role 用户角色
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 获取员工工号
	 * @return 员工工号
	 */
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * 设置员工工号
	 * @param employeeNumber 员工工号
	 */
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
	 * 获取姓名
	 * @return 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置姓名
	 * @param name 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取性别
	 * @return 性别
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * 设置性别
	 * @param gender 性别
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 获取年龄
	 * @return 年龄
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * 设置年龄
	 * @param age 年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * 获取联系电话
	 * @return 联系电话
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置联系电话
	 * @param phone 联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 获取邮箱
	 * @return 邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置邮箱
	 * @param email 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取身份证号码
	 * @return 身份证号码
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * 设置身份证号码
	 * @param idCard 身份证号码
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * 获取家庭住址
	 * @return 家庭住址
	 */
	public String getHomeAddress() {
		return homeAddress;
	}

	/**
	 * 设置家庭住址
	 * @param homeAddress 家庭住址
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	/**
	 * 获取头像
	 * @return 头像
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * 设置头像
	 * @param avatar 头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
} 