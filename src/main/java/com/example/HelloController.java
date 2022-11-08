package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private final Logger log = LoggerFactory.getLogger(HelloController.class);

	@GetMapping(path = "/")
	public String hello() {
		String message = "Hello from %s".formatted(Thread.currentThread());
		log.info(message);
		return message;
	}
}
