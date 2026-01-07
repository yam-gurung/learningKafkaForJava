package com.yam.kakfa.avro.serializers;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.yam.kakfa.avro.Photo;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
/**
 * 
 */
public class PhotoProducer {
    public static void main(String[] args) {
    	Properties props=new Properties();
    	props.setProperty("bootstrap.servers", "localhost:9092");
    	props.setProperty("key.serializer", KafkaAvroSerializer.class.getName());
    	props.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
    	props.setProperty("schema.registry.url", "http://localhost:8081");
    	
    	KafkaProducer<String,Photo> producer=new KafkaProducer<String,Photo>(props);
    	Photo photo = new Photo();
    	photo.setPhotoName("shyam");
    	photo.setPhotoId("shyam.jpg");
    	photo.setPhotoService("printing");
    	
		ProducerRecord<String, Photo> record=
    			new ProducerRecord<>("PhotoAvroTopic",photo.getPhotoName().toString(),photo);
    	try {
    		producer.send(record);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		producer.close();
    	}
    }
}
