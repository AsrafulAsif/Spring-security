package com.example.missyou.utils;

import com.example.missyou.response.SimpleResponseRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseMaking {

    public static ResponseEntity<SimpleResponseRest> makingResponse(){
        SimpleResponseRest response = new SimpleResponseRest();
        response.setStatus(200);
        response.setMessage("Successful.");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    public static ResponseEntity<SimpleResponseRest> makingResponse(SimpleResponseRest response){
        response.setStatus(200);
        response.setMessage("Successful.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
