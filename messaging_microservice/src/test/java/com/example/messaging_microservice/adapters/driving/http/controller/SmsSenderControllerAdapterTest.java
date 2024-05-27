package com.example.messaging_microservice.adapters.driving.http.controller;

import com.example.messaging_microservice.adapters.driving.http.dto.request.AddSmsSenderRequest;
import com.example.messaging_microservice.adapters.driving.http.mapper.request.ISmsSenderRequestMapper;
import com.example.messaging_microservice.domain.api.ISmsSenderServicePort;
import com.example.messaging_microservice.domain.model.SmsSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SmsSenderControllerAdapterTest {


    @Mock
    private ISmsSenderServicePort smsSenderServicePort;

    @Mock
    private ISmsSenderRequestMapper smsSenderRequestMapper;

    @InjectMocks
    private SmsSenderControllerAdapter smsSenderControllerAdapter;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(smsSenderControllerAdapter).build();
    }

    @Test
    void testSendSms() throws Exception {
        AddSmsSenderRequest addSmsSenderRequest = new AddSmsSenderRequest("+571234567890", "Test message");
        SmsSender smsSender = new SmsSender("+571234567890", "Test message");
        when(smsSenderRequestMapper.toSmsSender(any(AddSmsSenderRequest.class))).thenReturn(smsSender);

        mockMvc.perform(post("/sms-sender/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addSmsSenderRequest)))
                .andExpect(status().isOk());

        verify(smsSenderServicePort).sendSms(any(SmsSender.class));
    }

}