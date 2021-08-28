package com.teamwaw.kafka.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

	@Autowired
	private Producer producer;
	
	@RequestMapping("/")
	public String main() {
		return "Hello world";
	}
	
	@GetMapping("/kafka")
	public String sendMessage(@RequestParam("message") String message) {
		this.producer.sendMessage(message);
		
		return "success";
	}
}
