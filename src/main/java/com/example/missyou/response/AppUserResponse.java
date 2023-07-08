package com.example.missyou.response;

import com.example.missyou.entity.AppUser;
import com.example.missyou.enums.DeviceType;
import com.example.missyou.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserResponse {
    private String userName;
    private String userEmail;
    private String userPhoneNumber;
    private String userAddress;
    private String userProfilePicture;
    private Gender gender;
    private boolean isActive;
    private DeviceType deviceType;
    private String fcmToken;
    private Date createdAt;
    private Date updatedAt;

    public AppUserResponse(AppUser appUser){
        this.userName = appUser.getUserName();
        this.userEmail= appUser.getUserEmail();
        this.userPhoneNumber = appUser.getUserPhoneNumber();
        this.userAddress = appUser.getUserAddress();
        this.userProfilePicture = appUser.getUserProfilePicture();
        this.gender = appUser.getGender();
        this.isActive = appUser.isActive();
        this.deviceType =appUser.getDeviceType();
        this.fcmToken = appUser.getFcmToken();
        this.createdAt = appUser.getCreatedAt();
        this.updatedAt = appUser.getUpdatedAt();
    }
}
