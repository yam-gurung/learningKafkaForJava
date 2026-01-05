package com.yam.kafka.assignment2.customeserializers;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PhotoSerializer implements Serializer<Photo> {

	@Override
	public byte[] serialize(String topic, Photo photo) {
		byte[] response=null;
		ObjectMapper objectMapper =new ObjectMapper();
		try {
			response = objectMapper.writeValueAsString(photo).getBytes();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}

}
