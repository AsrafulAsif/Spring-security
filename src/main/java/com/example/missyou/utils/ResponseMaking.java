package com.example.missyou.utils;

import com.example.missyou.response.SampleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseMaking {
    public static SampleResponse makingSampleResponse(String status, String message){
        SampleResponse sampleResponse = SampleResponse.builder()
                .status(status)
                .message(message)
                .build();
        return sampleResponse;
    }

    public static ResponseEntity<SampleResponse> makingResponse(SampleResponse response){
        response.setStatus("200");
        response.setMessage("Successful.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
