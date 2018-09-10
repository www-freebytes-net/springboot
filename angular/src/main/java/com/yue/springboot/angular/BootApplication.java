package com.yue.springboot.angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

/**
 * auhtor 千里明月
 */

@SpringBootApplication
@ComponentScan({"com.yue.springboot.angular"})
public class BootApplication {
	private static ApplicationContext context;
	public static void main(String[] args) throws IOException {
		context = SpringApplication.run(BootApplication.class,args);
    }
}
