package com.ysstech;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * 加上@EnableDiscoveryClient注解，该注解能激活Eureka中的DiscoveryClient实现，
 * 才能实现Controller中对服务信息的输出。
 * */
@ServletComponentScan
//@EnableDiscoveryClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
