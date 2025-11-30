package com.stt.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stt.configuration.SpeechToTextClient;
import com.stt.configuration.SpeechToTextClientConfig;
import com.stt.request.SpeechToTextRequest;
import com.stt.response.SpeechToTextResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpeechToTextService {

    private final SpeechToTextClient sttClient;
    private final SpeechToTextClientConfig sttClientConfig;


    public SpeechToTextResponse transcribe(SpeechToTextRequest sttRequest){
    	SpeechToTextRequest transcribeRequest = SpeechToTextRequest.builder()
                .model(sttClientConfig.getModel())
                .file(sttRequest.getFile())
                .build();
        return sttClient.transcribe(transcribeRequest);
    }


	public SpeechToTextResponse transcribeAudio(MultipartFile audio) throws IOException {
		SpeechToTextRequest transcribeRequest = SpeechToTextRequest.builder()
                .model(sttClientConfig.getModel())
                .file(audio)
                .build();
		return sttClient.transcribeAudio(transcribeRequest);
	}
	
	public SpeechToTextResponse translateAudio(MultipartFile audio) throws IOException {
		SpeechToTextRequest translateRequest = SpeechToTextRequest.builder()
                .model(sttClientConfig.getModel())
                .file(audio)
                .build();
		return sttClient.translateAudio(translateRequest);
	}
}
