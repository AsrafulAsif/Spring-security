package com.example.missyou.controller.rest;

import com.example.missyou.request.AppUserLoginRequest;
import com.example.missyou.response.SampleResponse;
import com.example.missyou.service.AppUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/app-user")
public class AppUserLoginController {
    @Autowired
    AppUserLoginService appUserLoginService;

    @PostMapping("/registration")
    ResponseEntity<SampleResponse>  registrationAppUser(
            @RequestBody AppUserLoginRequest request
            ){
        SampleResponse sampleResponse = appUserLoginService.saveAppUser(request);
        return new ResponseEntity<>(sampleResponse,HttpStatus.OK);
    }

}
