package com.example;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private final Logger log = LoggerFactory.getLogger(HelloController.class);

	private final HelloService helloService;

	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	@GetMapping(path = "/")
	public String hello() {
		String message = "Hello from %s".formatted(Thread.currentThread());
		log.info(message);
		return message;
	}

	@GetMapping(path = "/async")
	public CompletableFuture<String> helloAsync() {
		return this.helloService.hello();
	}
}
