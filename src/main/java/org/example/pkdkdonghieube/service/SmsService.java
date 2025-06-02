package org.example.pkdkdonghieube.service;

import org.example.pkdkdonghieube.dto.SmsRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsService {

    @Value("${tingting.api.url}")
    private String apiUrl;

    @Value("${tingting.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String sendSms(String to, String content, String sender, String sendTime) {
        // Chuẩn bị body
        SmsRequest request = new SmsRequest();
        request.setTo(to);
        request.setContent(content);
        request.setSender(sender);
        request.setSendTime(sendTime);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apikey", apiKey);

        HttpEntity<SmsRequest> entity = new HttpEntity<>(request, headers);

        // Gửi request
        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }
}
