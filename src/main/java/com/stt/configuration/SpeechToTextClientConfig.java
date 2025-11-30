package com.stt.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import lombok.Data;

@Configuration
@Data
public class SpeechToTextClientConfig {


    @Value("${stt.api-key}")
    private String apiKey;

    @Value("${stt.audio-model}")
    private String model;


    @Bean
    public RequestInterceptor apiKeyInterceptor() {
        return request -> request.header("Authorization", "Bearer " + apiKey);
    }
}

