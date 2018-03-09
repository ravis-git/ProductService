package com.example.productservice;

import com.my.experiments.microservices.chassis.ChassisMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@SpringBootApplication
//@EnableDiscoveryClient
public class DemoApplication extends ChassisMain {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
