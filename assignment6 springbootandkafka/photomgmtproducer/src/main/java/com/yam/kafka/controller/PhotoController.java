package com.yam.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yam.kafka.dto.Photo;
import com.yam.kafka.service.PhotoProducerService;

@RestController
@RequestMapping("/photoapi")
public class PhotoController {

	@Autowired
	private PhotoProducerService service;
	
	@PostMapping("/sendPhotoServiceRequest")
	public void sendPhotoServiceRequest(
			@RequestBody Photo photo) {
		this.service.sendRequestForPhotoService(photo);
	}
	
}
