package com.yam.kafka.photoproducer;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
/**
 * 
 */
public class PhotoProducer {
    public static void main(String[] args) {
    	Properties props=new Properties();
    	props.setProperty("bootstrap.servers", "localhost:9092");
    	props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    	props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    	
    	KafkaProducer<String,String> producer=new KafkaProducer<String,String>(props);
    	ProducerRecord<String, String> record=
    			new ProducerRecord<>("photo-topic","photo-shyam","shyam.jpg");
    	try {
    		//producer.send(record);
    		RecordMetadata recordMetadata = producer.send(record).get();
    		System.out.println("partition: "+recordMetadata.partition());
    		System.out.println("offset: "+recordMetadata.offset());
    		System.out.println("send successfully");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		producer.close();
    	}
    }
}
