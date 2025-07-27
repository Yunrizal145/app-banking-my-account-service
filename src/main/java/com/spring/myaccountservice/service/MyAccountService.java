package com.spring.myaccountservice.service;

import com.spring.myaccountmanagementservice.dto.SaveUserAccountRequest;
import com.spring.usermanagementservice.dto.SetPasswordRequest;
import com.spring.usermanagementservice.dto.SetPasswordResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyAccountService {

    @Autowired
    private UserManagementService userManagementService;

    @Autowired
    private MyAccountManagementService myAccountManagementService;

    public SetPasswordResponse setPasswordAndMpin(SetPasswordRequest request){
        log.info("setPasswordAndMpin start ... ");
        SetPasswordResponse setPasswordResponse = new SetPasswordResponse();
        try {
            var setPassword = userManagementService.setPasswordAndMpin(request);
            if (setPassword.getMessage().equals("Data Registered Success")) {
                myAccountManagementService.saveAccountUser(SaveUserAccountRequest.builder()
                        .userProfileId(setPassword.getUserData().getId())
                        .build());

                setPasswordResponse.setMessage(setPassword.getMessage());
                setPasswordResponse.setUserData(setPassword.getUserData());
            }
            return setPasswordResponse;
        } catch (Exception e) {
            throw new RuntimeException("error when set password and mpin");
        }
    }


}
