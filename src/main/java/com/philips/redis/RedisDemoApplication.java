package com.philips.redis;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;


import java.util.List;


@SpringBootApplication
@ComponentScan({"com.philips.redis","com.philips.redis.config","com.philips.redis.repository"})


public class RedisDemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class, args);
	}

}
