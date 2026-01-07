package com.yam.kakfa.avro.deserializers;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.avro.generic.GenericRecord;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * 
 */
public class GenericPhotoConsumer {
    public static void main(String[] args) {
    	Properties props=new Properties();
    	props.setProperty("bootstrap.servers", "localhost:9092");
    	props.setProperty("key.deserializer", KafkaAvroDeserializer.class.getName());
    	props.setProperty("value.deserializer", KafkaAvroDeserializer.class.getName());
    	props.setProperty("group.id", "consumergrptest");
    	props.setProperty("schema.registry.url", "http://localhost:8081");
    	
    	KafkaConsumer<String,GenericRecord> consumer=new KafkaConsumer<>(props);
    	consumer.subscribe(Collections.singleton("PhotoAvroGRTopic"));
    	
    	ConsumerRecords<String,GenericRecord> records=consumer.poll(Duration.ofSeconds(20));
    	for(ConsumerRecord<String,GenericRecord> record:records){
    		String photoUserName = record.key();
    		GenericRecord photo = record.value();
    		System.out.println("photoName: "+photoUserName);
    		System.out.println("photoId: "+photo.get("photoId"));
    		System.out.println("photoService: "+photo.get("photoService"));
    	};
    	
    	consumer.close();
    }
}
