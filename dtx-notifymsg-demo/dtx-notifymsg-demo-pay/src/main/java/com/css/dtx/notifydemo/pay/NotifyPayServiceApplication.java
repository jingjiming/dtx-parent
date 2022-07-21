package com.css.dtx.notifydemo.pay;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class NotifyPayServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotifyPayServiceApplication.class, args);
	}

}
