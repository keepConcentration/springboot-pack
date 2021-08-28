package com.teamwaw.kafka.web;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	@KafkaListener(topics = {"kafka"}, groupId = "teamWaw")
	public void consume(String message) throws IOException {
		System.out.println("consumed message : " + message);
	}
}
