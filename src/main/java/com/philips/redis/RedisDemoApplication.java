package com.philips.redis;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.List;


@SpringBootApplication
@ComponentScan({"com.philips.redis","com.philips.redis.config","com.philips.redis.repository"})
@RestController
public class RedisDemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class, args);
	}
	@RequestMapping("/")
	public String hello(HttpServletRequest request) throws InterruptedException {
		System.out.println(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort());
		return "Welcome to Sample Redis Application "+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
	}
}
