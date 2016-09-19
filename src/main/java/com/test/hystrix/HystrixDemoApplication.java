package com.test.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@ComponentScan
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableDiscoveryClient
public class HystrixDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDemoApplication.class, args);
	}

	@HystrixCommand
	@RequestMapping(value = "/test")
	public String testApp() {
		return "Hello Application";
	}

	@HystrixCommand
	@RequestMapping(value = "/abcd")
	public String testAppAB() {
		return "Hello Application";
	}


}