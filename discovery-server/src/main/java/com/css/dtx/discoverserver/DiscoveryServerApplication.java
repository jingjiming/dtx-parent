package com.css.dtx.discoverserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>> 注册中心 服务启动成功！>>>>>>>>>>>>>>>>>>>");
	}
}
