package com.example;

import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemoVirtualThreadsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoVirtualThreadsApplication.class, args);
	}


	@Bean(TaskExecutionAutoConfiguration.APPLICATION_TASK_EXECUTOR_BEAN_NAME)
	public AsyncTaskExecutor asyncTaskExecutor() {
		return new TaskExecutorAdapter(Executors.newVirtualThreadPerTaskExecutor());
	}

	@Bean
	public TomcatProtocolHandlerCustomizer<?> protocolHandlerVirtualThreadExecutorCustomizer() {
		return handler -> handler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
	}
}
