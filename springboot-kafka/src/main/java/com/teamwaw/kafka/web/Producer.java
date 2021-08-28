package com.teamwaw.kafka.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

	private static final String TOPIC = "kafka";
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	public Producer (KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String message) {
		System.out.println("ProductMessage :  " + message);
		
		this.kafkaTemplate.send(TOPIC, message);
	}
 }
