package com.mlf.entity;

/**
 * 用户信息
 * 
 * @author MINGYONGZHANG
 *
 */
public class UserInfo extends Entity {

	private static final long serialVersionUID = 7902095210608238284L;

	private int userId;
	private String userName;
	private String userPwd;
	private String userStatus;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

}
