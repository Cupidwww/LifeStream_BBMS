package com.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/** 
 * token表
 */
@TableName("token")
public class TokenEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@TableId(type = IdType.AUTO)
	private Long id;
	
	/**
	 * 用户id
	 */
	private Long userid;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 表名
	 */
	private String tablename;
	
	/**
	 * 角色
	 */
	private String role;
	
	/**
	 * token
	 */
	private String token;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TokenEntity(Long userid, String username, String tablename, String role, String token) {
		super();
		this.userid = userid;
		this.username = username;
		this.tablename = tablename;
		this.role = role;
		this.token = token;
	}
	
	public TokenEntity() {
	}
	
}
