package com.yam.kafka.assignment2.customeserializers;

public class Photo {
	private String photoName;
	private String photoId;
	private String photoService;

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getPhotoService() {
		return photoService;
	}

	public void setPhotoService(String photoService) {
		this.photoService = photoService;
	}
}
