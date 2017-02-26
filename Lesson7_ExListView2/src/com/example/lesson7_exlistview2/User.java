package com.example.lesson7_exlistview2;

public class User {

	int imgId;
	String nickname;
	boolean isOnline;
	String sign;
	

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public User(int imgId, String nickname, boolean isOnline, String sign) {
		super();
		this.imgId = imgId;
		this.nickname = nickname;
		this.isOnline = isOnline;
		this.sign = sign;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [imgId=" + imgId + ", nickname=" + nickname
				+ ", isOnline=" + isOnline + ", sign=" + sign + "]";
	}

}