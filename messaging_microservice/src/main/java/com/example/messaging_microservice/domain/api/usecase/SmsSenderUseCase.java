package com.example.messaging_microservice.domain.api.usecase;

import com.example.messaging_microservice.domain.api.ISmsSenderServicePort;
import com.example.messaging_microservice.domain.model.SmsSender;
import com.example.messaging_microservice.domain.spi.ISmsSenderService;

public class SmsSenderUseCase implements ISmsSenderServicePort {

    private final ISmsSenderService smsSenderService;

    public SmsSenderUseCase(ISmsSenderService smsSenderService) {
        this.smsSenderService = smsSenderService;
    }

    @Override
    public void sendSms(SmsSender smsSender) {
        smsSenderService.sendSms(smsSender);

    }

    @Override
    public String getMessage(String number) {
        return smsSenderService.getMessage(number);
    }
}
