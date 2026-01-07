package com.yam.kakfa.avro.deserializers;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.yam.kakfa.avro.Photo;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;

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
    	Properties props=new Properties();
    	props.setProperty("bootstrap.servers", "localhost:9092");
    	props.setProperty("key.deserializer", KafkaAvroDeserializer.class.getName());
    	props.setProperty("value.deserializer", KafkaAvroDeserializer.class.getName());
    	props.setProperty("group.id", "consumergrptest");
    	props.setProperty("schema.registry.url", "http://localhost:8081");
    	props.setProperty("specific.avro.reader", "true");
    	
    	KafkaConsumer<String,Photo> consumer=new KafkaConsumer<>(props);
    	consumer.subscribe(Collections.singleton("PhotoAvroTopic"));
    	
    	ConsumerRecords<String,Photo> records=consumer.poll(Duration.ofSeconds(20));
    	for(ConsumerRecord<String,Photo> record:records){
    		String photoUserName = record.key();
    		Photo photo = record.value();
    		System.out.println("photoName: "+photoUserName);
    		System.out.println("photoId: "+photo.getPhotoId());
    		System.out.println("photoService: "+photo.getPhotoService());
    	};
    	
    	consumer.close();
    }
}
