package com.example.demo;

import com.example.demo.Producer.MessageProducer;
import com.example.demo.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	MessageProducer messageProducer;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/kafka/{id}")
	public String sendViaKafka(@PathVariable int id){
		Message message = new Message();
		message.setId(id);
		messageProducer.send(message);
		return "sss";
	}
}
