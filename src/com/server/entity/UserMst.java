package com.server.entity;

import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;

@Alias("UserMst")
public class UserMst {

	private BigDecimal id;
	private String name;

	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}