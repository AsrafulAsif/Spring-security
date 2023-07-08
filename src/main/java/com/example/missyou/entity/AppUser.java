package com.example.missyou.entity;

import com.example.missyou.enums.DeviceType;
import com.example.missyou.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("app-user")
public class AppUser {
    @Id
    private String id;
    private String userName;
    private String userEmail;
    private String userPhoneNumber;
    private String userPassword;
    private String userAddress;
    private String userProfilePicture;
    private Gender gender;
    private boolean isActive;
    private DeviceType deviceType;
    private String fcmToken;
    private Date createdAt;
    private Date updatedAt;
}
