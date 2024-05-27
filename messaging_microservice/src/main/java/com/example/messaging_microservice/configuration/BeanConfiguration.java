package com.example.messaging_microservice.configuration;

import com.example.messaging_microservice.adapters.driving.sms.SmMService;
import com.example.messaging_microservice.domain.api.ISmsSenderServicePort;
import com.example.messaging_microservice.domain.api.usecase.SmsSenderUseCase;
import com.example.messaging_microservice.domain.spi.ISmsSenderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class BeanConfiguration {
    private final ISmsSenderService smsSenderService;

    @Bean
    public ISmsSenderService smsSenderService(ISmsSenderService smsSenderService){
        return smsSenderService;
    }

    @Bean
    public ISmsSenderServicePort smsSenderServicePort(ISmsSenderService smsSenderService){
        return new SmsSenderUseCase(smsSenderService);
    }

}
