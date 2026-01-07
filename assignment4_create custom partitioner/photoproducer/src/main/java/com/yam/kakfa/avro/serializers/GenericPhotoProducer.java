package com.yam.kakfa.avro.serializers;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.Schema;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
/**
 * 
 */
public class GenericPhotoProducer {
    public static void main(String[] args) {
    	Properties props=new Properties();
    	props.setProperty("bootstrap.servers", "localhost:9092");
    	props.setProperty("key.serializer", KafkaAvroSerializer.class.getName());
    	props.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
    	props.setProperty("schema.registry.url", "http://localhost:8081");
    	
    	KafkaProducer<String,GenericRecord> producer=new KafkaProducer<>(props);
    	Schema.Parser parser = new Schema.Parser();
    	Schema schema = parser.parse("{\n"
    			+ "\"namespace\": \"com.yam.kakfa.avro\",\n"
    			+ "\"type\": \"record\",\n"
    			+ "\"name\": \"Photo\",\n"
    			+ "\"fields\": [\n"
    			+ "{\"name\": \"photoName\",\"type\":\"string\"},\n"
    			+ "{\"name\": \"photoId\",\"type\":\"string\"},\n"
    			+ "{\"name\": \"photoService\",\"type\":\"string\"}\n"
    			+ "]\n"
    			+ "}");
    	
    	GenericRecord photo=new GenericData.Record(schema);
    	photo.put("photoName", "shyam");
    	photo.put("photoId", "shyam.jpg");
    	photo.put("photoService", "printing");
    	
		ProducerRecord<String, GenericRecord> record=
    			new ProducerRecord<>("PhotoAvroGRTopic",photo.get("photoName").toString(),photo);
    	try {
    		producer.send(record);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		producer.close();
    	}
    }
}
