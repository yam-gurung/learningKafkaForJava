package com.yam.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.yam.kafka.dto.Photo;

@Service
public class PhotoProducerService {

	@Autowired
	private KafkaTemplate<String,Photo> kafkaTemplate;
	
	public void sendRequestForPhotoService(Photo photo) {
		this.kafkaTemplate.send("photo-topic", photo.getUserPhotoId(),photo);
		
	}
	
}
