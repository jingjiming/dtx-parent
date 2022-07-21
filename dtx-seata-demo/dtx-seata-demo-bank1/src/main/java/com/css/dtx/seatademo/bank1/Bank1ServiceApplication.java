package com.css.dtx.seatademo.bank1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = {"com.css.dtx.seatademo.bank1.spring"})
public class Bank1ServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(Bank1ServiceApplication.class, args);

	}

}
