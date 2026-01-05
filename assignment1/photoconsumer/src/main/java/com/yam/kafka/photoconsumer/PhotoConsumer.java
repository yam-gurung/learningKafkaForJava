package com.yam.kafka.photoconsumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
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
    	props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    	props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    	props.setProperty("group.id", "consumergrptest");
    	
    	KafkaConsumer<String,String> consumer=new KafkaConsumer<>(props);
    	consumer.subscribe(Collections.singleton("photo-topic"));
    	
    	ConsumerRecords<String,String> photos=consumer.poll(Duration.ofSeconds(20));
    	for(ConsumerRecord<String,String> photo:photos){
    		System.out.println("Photo User name: "+photo.key());
    		System.out.println("Photo user photo id: "+photo.value());
    	};
    	
    	consumer.close();
    }
}
