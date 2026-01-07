package com.yam.kafka.assignment2.customedeserializers.photoconsumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * 
 */
public class PhotoConsumer {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.deserializer", StringDeserializer.class.getName());
		props.setProperty("value.deserializer", PhotoDeserializer.class.getName());
		props.setProperty("group.id", "consumergrptest");

		KafkaConsumer<String, Photo> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Collections.singleton("PhotoCSTopic"));

		try {
			while (true) {
				ConsumerRecords<String, Photo> records = consumer.poll(Duration.ofSeconds(20));
				for (ConsumerRecord<String, Photo> record : records) {
					String photoUserName = record.key();
					Photo photo = record.value();
					System.out.println("photoName: " + photoUserName);
					System.out.println("photoId: " + photo.getPhotoId());
					System.out.println("photoService: " + photo.getPhotoService());
				}
			}
		} finally {
			consumer.close();
		}
	}
}
