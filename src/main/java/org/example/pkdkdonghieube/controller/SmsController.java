package org.example.pkdkdonghieube.controller;

import org.example.pkdkdonghieube.dto.SmsRequest;
import org.example.pkdkdonghieube.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sms")
public class SmsController {
    @Autowired
    private SmsService smsService;

    @PostMapping("/send")
    public String sendSms(@RequestBody SmsRequest request) {
        return smsService.sendSms(request.getTo(), request.getContent(), request.getSender(), request.getSendTime());
    }
}
