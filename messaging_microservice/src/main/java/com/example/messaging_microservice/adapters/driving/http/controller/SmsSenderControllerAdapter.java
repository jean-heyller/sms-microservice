package com.example.messaging_microservice.adapters.driving.http.controller;

import com.example.messaging_microservice.adapters.driving.http.dto.request.AddSmsSenderRequest;
import com.example.messaging_microservice.adapters.driving.http.mapper.request.ISmsSenderRequestMapper;
import com.example.messaging_microservice.domain.api.ISmsSenderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sms-sender")
@RequiredArgsConstructor
@Validated
public class SmsSenderControllerAdapter {

    private final ISmsSenderServicePort smsSenderServicePort;

    private final ISmsSenderRequestMapper smsSenderRequestMapper;

    @PreAuthorize("permitAll()")
    @PostMapping("/send")
    public ResponseEntity<Void> sendSms(@RequestBody AddSmsSenderRequest addSmsSenderRequest) {
        smsSenderServicePort.sendSms(smsSenderRequestMapper.toSmsSender(addSmsSenderRequest));
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/message")
    public ResponseEntity<String> getMessage(@RequestParam String number) {
        return ResponseEntity.ok(smsSenderServicePort.getMessage(number));
    }


}
