package com.css.dtx.seatademo.bank2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = {"com.css.dtx"})
public class Bank2ServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(Bank2ServiceApplication.class, args);

	}

}
