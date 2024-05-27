package com.example.messaging_microservice.domain.spi;

import com.example.messaging_microservice.domain.model.SmsSender;

public interface ISmsSenderService {

    void sendSms(SmsSender smsSender);
    String getMessage(String number);
}
