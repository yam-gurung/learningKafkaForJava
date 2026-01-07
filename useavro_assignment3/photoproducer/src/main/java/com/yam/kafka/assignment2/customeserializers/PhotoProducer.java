package com.yam.kafka.assignment2.customeserializers;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
/**
 * 
 */
public class PhotoProducer {
    public static void main(String[] args) {
    	Properties props=new Properties();
    	props.setProperty("bootstrap.servers", "localhost:9092");
    	props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    	props.setProperty("value.serializer", "com.yam.kafka.assignment2.customeserializers.PhotoSerializer");
    	
    	KafkaProducer<String,Photo> producer=new KafkaProducer<String,Photo>(props);
    	Photo photo = new Photo();
    	photo.setPhotoName("shyam");
    	photo.setPhotoId("shyam.jpg");
    	photo.setPhotoService("printing");
    	
		ProducerRecord<String, Photo> record=
    			new ProducerRecord<>("PhotoCSTopic",photo.getPhotoName(),photo);
    	try {
    		producer.send(record);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		producer.close();
    	}
    }
}
