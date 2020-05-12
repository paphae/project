package com.entity;

import java.io.Serializable;

public class Invite implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 123456L;
	private Integer code;
	private Integer status;
	public Invite(Integer status) {
		super();
		this.status = status;
	}
	public Invite() {
		super();
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
