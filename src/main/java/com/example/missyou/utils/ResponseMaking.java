package com.example.missyou.utils;

import com.example.missyou.response.SampleResponse;

public class ResponseMaking {
    public static SampleResponse makingSampleResponse(String status, String message){
        SampleResponse sampleResponse = SampleResponse.builder()
                .status(status)
                .message(message)
                .build();
        return sampleResponse;
    }
}
