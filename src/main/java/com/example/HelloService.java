package com.example;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	private final Logger log = LoggerFactory.getLogger(HelloService.class);

	@Async
	public CompletableFuture<String> hello() {
		String message = "Hello from %s".formatted(Thread.currentThread());
		log.info(message);
		return CompletableFuture.completedFuture(message);
	}
}
