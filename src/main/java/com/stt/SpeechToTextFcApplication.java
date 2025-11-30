package com.stt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpeechToTextFcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeechToTextFcApplication.class, args);
	}

}
