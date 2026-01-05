package com.yam.kafka.assignment2.customedeserializers.photoconsumer;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PhotoDeserializer implements Deserializer<Photo> {

	@Override
	public Photo deserialize(String topic, byte[] data) {
		ObjectMapper objectMapper=new ObjectMapper();
		Photo photo=null;
		
		try {
			 photo = objectMapper.readValue(data, Photo.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return photo;
	}

}
