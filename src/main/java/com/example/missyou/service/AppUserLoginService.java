package com.example.missyou.service;

import com.example.missyou.entity.AppUser;
import com.example.missyou.exeption.BadRequestException;
import com.example.missyou.repository.AppUserRepository;
import com.example.missyou.request.AppUserRegistrationRequest;
import com.example.missyou.response.SimpleResponseRest;
import com.example.missyou.response.AppUserResponse;
import com.example.missyou.response.rest.UserResponseRest;
import com.example.missyou.utils.ResponseMaking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AppUserLoginService {
    private final AppUserRepository appUserRepository;

    public AppUserLoginService(AppUserRepository appUserLoginRepository) {
        this.appUserRepository = appUserLoginRepository;
    }

    public void registrationAppUser(AppUserRegistrationRequest request){
        AppUser existAppuser = appUserRepository.findByUserNameAndUserPhoneNumber(request.getUserName(),request.getUserPhoneNumber());
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
        appUserRepository.save(appUser);
    }
    public UserResponseRest getAllUser(){
        List<AppUser> userResponseList = appUserRepository.findAll();
        UserResponseRest userResponseRest = new UserResponseRest();
        List<AppUserResponse> appUserResponses = userResponseList.stream().map(AppUserResponse::new).collect(Collectors.toList());
        userResponseRest.setUserResponse(appUserResponses);
        return userResponseRest ;
    }
}
