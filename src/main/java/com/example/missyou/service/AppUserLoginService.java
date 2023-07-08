package com.example.missyou.service;

import com.example.missyou.entity.AppUser;
import com.example.missyou.exeptionandler.BadRequestException;
import com.example.missyou.repository.AppUserLoginRepository;
import com.example.missyou.request.AppUserLoginRequest;
import com.example.missyou.response.SampleResponse;
import com.example.missyou.utils.ResponseMaking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class AppUserLoginService {
    private final AppUserLoginRepository appUserLoginRepository;

    @Autowired
    public AppUserLoginService(AppUserLoginRepository appUserLoginRepository) {
        this.appUserLoginRepository = appUserLoginRepository;
    }

    public SampleResponse registrationAppUser(AppUserLoginRequest request){
        AppUser existAppuser = appUserLoginRepository.findByUserNameAndUserPhoneNumber(request.getUserName(),request.getUserPhoneNumber());
        if (existAppuser!=null) throw new BadRequestException("User already exist.");
        AppUser appUser = AppUser.builder()
                .userName(request.getUserName())
                .userEmail(request.getUserEmail())
                .userPhoneNumber(request.getUserPhoneNumber())
                .userPassword(request.getUserPassword())
                .userAddress(request.getUserAddress())
                .userProfilePicture(request.getUserProfilePicture())
                .gender(request.getGender())
                .isActive(true)
                .deviceType(request.getDeviceType())
                .fcmToken(request.getFcmToken())
                .createdAt(new Date(System.currentTimeMillis()))
                .build();
        appUserLoginRepository.save(appUser);
        return ResponseMaking.makingSampleResponse("200","Registration Successful.");
    }
}
