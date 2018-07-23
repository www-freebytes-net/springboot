package com.yue.springboot.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * auhtor 千里明月
 */
@SpringBootApplication
public class BootApplication {
	private static ApplicationContext context;
	public static void main(String[] args){
		context = SpringApplication.run(BootApplication.class,args);
	}
}
