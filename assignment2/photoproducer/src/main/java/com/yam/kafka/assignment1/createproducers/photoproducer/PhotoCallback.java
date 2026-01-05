package com.yam.kafka.assignment1.createproducers.photoproducer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class PhotoCallback implements Callback {

	@Override
	public void onCompletion(RecordMetadata metadata, Exception exception) {
		System.out.println("partition: "+metadata.partition());
		System.out.println("offset: "+metadata.offset());
		System.out.println("send successfully");
		if(exception!=null) {
			exception.printStackTrace();
		}
	}

}
