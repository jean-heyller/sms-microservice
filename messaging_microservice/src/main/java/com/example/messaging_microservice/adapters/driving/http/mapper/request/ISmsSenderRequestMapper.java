package com.example.messaging_microservice.adapters.driving.http.mapper.request;

import com.example.messaging_microservice.adapters.driving.http.dto.request.AddSmsSenderRequest;
import com.example.messaging_microservice.domain.model.SmsSender;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISmsSenderRequestMapper {
    SmsSender toSmsSender(AddSmsSenderRequest addSmsSenderRequest);
}
