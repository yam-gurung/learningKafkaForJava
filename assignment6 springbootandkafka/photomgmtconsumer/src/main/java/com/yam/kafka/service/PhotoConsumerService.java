package com.yam.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.yam.kafka.dto.Photo;

@Service
public class PhotoConsumerService {

	@KafkaListener(topics= {"photo-topic"})
	public void consumerPhotoServiceRequest(Photo photo) {
		System.out.println("photoId serviceType " 
				+ photo.getUserPhotoId()+" "+photo.getUserPhotoServiceType());
	}
	
}
