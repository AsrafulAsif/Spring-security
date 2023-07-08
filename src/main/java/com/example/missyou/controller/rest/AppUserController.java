package com.example.missyou.controller.rest;

import com.example.missyou.request.AppUserRegistrationRequest;
import com.example.missyou.response.SimpleResponseRest;
import com.example.missyou.response.rest.UserResponseRest;
import com.example.missyou.service.AppUserLoginService;
import com.example.missyou.utils.ResponseMaking;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/app-user")
public class AppUserController {

    private final AppUserLoginService appUserLoginService;

    @Autowired
    public AppUserController(AppUserLoginService appUserLoginService){
        this.appUserLoginService = appUserLoginService;
    }

    @PostMapping("/registration")
    ResponseEntity<SimpleResponseRest>  registrationAppUser(
            @RequestBody @Valid AppUserRegistrationRequest request
            ){
        appUserLoginService.registrationAppUser(request);
        return ResponseMaking.makingResponse();
    }
    @GetMapping("/get-all-user")
    ResponseEntity<SimpleResponseRest>getAllUser(
    ){
        UserResponseRest userResponseRest = appUserLoginService.getAllUser();
        return ResponseMaking.makingResponse(userResponseRest);
    }

}
