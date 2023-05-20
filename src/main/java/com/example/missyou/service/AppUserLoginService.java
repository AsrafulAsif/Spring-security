package com.example.missyou.service;

import com.example.missyou.entity.AppUser;
import com.example.missyou.repository.AppUserLoginRepository;
import com.example.missyou.request.AppUserLoginRequest;
import com.example.missyou.response.SampleResponse;
import com.example.missyou.utils.ResponseMaking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppUserLoginService {
    @Autowired
    AppUserLoginRepository appUserLoginRepository;

    public SampleResponse saveAppUser(AppUserLoginRequest request){
        AppUser findingAppuser = appUserLoginRepository.findByUserNameAndPhoneNumber(request.getUsername(),request.getPhoneNumber());
        if (findingAppuser!=null) return ResponseMaking.makingSampleResponse("200","User found");
        AppUser appUser = AppUser.builder()
                .userName(request.getUsername())
                .phoneNumber(request.getPhoneNumber())
                .password(request.getPassword())
                .firebaseFCMToken(request.getFirebaseFCMToken())
                .build();
        appUserLoginRepository.save(appUser);
        SampleResponse sampleResponse = ResponseMaking.makingSampleResponse("200","saved");
        return sampleResponse;
    }
}
