package com.stt.configuration;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stt.request.SpeechToTextRequest;
import com.stt.response.SpeechToTextResponse;

@FeignClient(name = "Speech-To-Text", url = "${stt.urls.base-url}", configuration = SpeechToTextClientConfig.class)
public interface SpeechToTextClient {

	@PostMapping(value = "${stt.urls.transcribe-url}", headers = { "Content-Type=multipart/form-data" })
	SpeechToTextResponse transcribe(@ModelAttribute SpeechToTextRequest sttRequest);

	@PostMapping(value = "${stt.urls.transcribe-url}", headers = { "Content-Type=multipart/form-data" })
	SpeechToTextResponse transcribeAudio(SpeechToTextRequest transcribeRequest);

	@PostMapping(value = "${stt.urls.translate-url}", headers = { "Content-Type=multipart/form-data" })
	SpeechToTextResponse translateAudio(SpeechToTextRequest transcribeRequest);

}
