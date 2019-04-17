package com.transaction.user.model;

public class User {
	String id;
	String userId;
	String userName;
	String inviteCode;
	String myInviteCode;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getInviteCode() {
		return inviteCode;
	}
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}
	public String getMyInviteCode() {
		return myInviteCode;
	}
	public void setMyInviteCode(String myInviteCode) {
		this.myInviteCode = myInviteCode;
	}

}
