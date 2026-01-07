package com.yam.kafka.dto;

public class Photo {
	private String userPhotoName;
	private String userPhotoId;
	private String userPhotoServiceType;

	public String getUserPhotoName() {
		return userPhotoName;
	}

	public void setUserPhotoName(String userPhotoName) {
		this.userPhotoName = userPhotoName;
	}

	public String getUserPhotoId() {
		return userPhotoId;
	}

	public void setUserPhotoId(String userPhotoId) {
		this.userPhotoId = userPhotoId;
	}

	public String getUserPhotoServiceType() {
		return userPhotoServiceType;
	}

	public void setUserPhotoServiceType(String userPhotoServiceType) {
		this.userPhotoServiceType = userPhotoServiceType;
	}

}
