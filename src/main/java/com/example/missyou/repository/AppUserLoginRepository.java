package com.example.missyou.repository;

import com.example.missyou.entity.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserLoginRepository extends MongoRepository<AppUser,String> {
    AppUser findByUserNameAndPhoneNumber(String userName,String phoneNumber);
}
