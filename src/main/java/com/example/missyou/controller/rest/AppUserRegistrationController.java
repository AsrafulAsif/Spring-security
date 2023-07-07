package com.example.missyou.controller.rest;

import com.example.missyou.request.AppUserLoginRequest;
import com.example.missyou.response.SampleResponse;
import com.example.missyou.service.AppUserLoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/app-user")
public class AppUserRegistrationController {

    private final AppUserLoginService appUserLoginService;

    @Autowired
    public AppUserRegistrationController(AppUserLoginService appUserLoginService){
        this.appUserLoginService = appUserLoginService;
    }

    @PostMapping("/registration")
    ResponseEntity<SampleResponse>  registrationAppUser(
            @RequestBody @Valid AppUserLoginRequest request
            ){
        SampleResponse sampleResponse = appUserLoginService.saveAppUser(request);
        return new ResponseEntity<>(sampleResponse,HttpStatus.OK);
    }

}
