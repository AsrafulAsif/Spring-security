package com.example.missyou.request;

import com.example.missyou.enums.DeviceType;
import com.example.missyou.enums.Gender;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserLoginRequest {
    @NotNull(message = "User name can not e null.")
    @Size(min = 4, max = 30, message = "The length of full name must be between 4 and 30 characters.")
    private String userName;
    @NotNull(message = "User email can not e null.")
    private String userEmail;
    @NotNull(message = "User phone number can not e null.")
    private String userPhoneNumber;
    @NotNull(message = "User password can not e null.")
    private String userPassword;
    private String userAddress;
    private String userProfilePicture;
    private Gender gender;
    private DeviceType deviceType;
    private String fcmToken;

}
