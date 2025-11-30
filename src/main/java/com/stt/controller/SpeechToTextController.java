package com.stt.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stt.request.SpeechToTextRequest;
import com.stt.response.SpeechToTextResponse;
import com.stt.service.SpeechToTextService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SpeechToTextController {

    private final SpeechToTextService sttService;


    @PostMapping(value = "/transcription", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SpeechToTextResponse transcribe(@ModelAttribute SpeechToTextRequest transcriptionRequest){
        return sttService.transcribe(transcriptionRequest);
    }
 
    
    @PostMapping(value = "/transcribe-audio", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SpeechToTextResponse transcribeAudio(MultipartFile audio) throws IOException {
    	System.out.println("The transcription is : " + sttService.transcribeAudio(audio));
        return sttService.transcribeAudio(audio);
    }

    @PostMapping(value = "/translate-audio", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SpeechToTextResponse translateAudio(MultipartFile audio) throws IOException {
    	System.out.println("The translation is : " + sttService.translateAudio(audio));
        return sttService.translateAudio(audio);
    }
}
