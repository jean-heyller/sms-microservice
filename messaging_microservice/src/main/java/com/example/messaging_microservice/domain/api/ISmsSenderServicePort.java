package com.example.messaging_microservice.domain.api;

import com.example.messaging_microservice.domain.model.SmsSender;

public interface ISmsSenderServicePort {
    void sendSms(SmsSender smsSender);

    String getMessage(String number);
}
