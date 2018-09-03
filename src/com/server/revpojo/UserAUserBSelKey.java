package com.server.revpojo;

import org.apache.ibatis.type.Alias;

@Alias("UserAUserB_SEL_KEY")
public class UserAUserBSelKey {

	private String userA;
	private String userB;

	public String getUserA() {
		return userA;
	}
	public void setUserA(String userA) {
		this.userA = userA;
	}
	public String getUserB() {
		return userB;
	}
	public void setUserB(String userB) {
		this.userB = userB;
	}

}