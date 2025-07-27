package com.spring.myaccountservice.controller;

import com.spring.myaccountservice.service.MyAccountService;
import com.spring.myaccountservice.service.UserManagementService;
import com.spring.usermanagementservice.dto.OtpRequest;
import com.spring.usermanagementservice.dto.OtpValidationRequest;
import com.spring.usermanagementservice.dto.OtpValidationResponse;
import com.spring.usermanagementservice.dto.SaveDataUserRegisterRequest;
import com.spring.usermanagementservice.dto.SaveDataUserRegisterResponse;
import com.spring.usermanagementservice.dto.SetPasswordRequest;
import com.spring.usermanagementservice.dto.SetPasswordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAccountServiceController {

    @Autowired
    private UserManagementService userManagementService;

    @Autowired
    private MyAccountService myAccountService;

    @PostMapping("/send-otp")
    public void sendotp(@RequestBody OtpRequest otpRequest) {
        userManagementService.sendOtp(otpRequest);
    }

    @PostMapping("/otp-verification")
    public OtpValidationResponse sendotp(@RequestBody OtpValidationRequest otpRequest) {
        return userManagementService.otpValidation(otpRequest);
    }

    @PostMapping("/saveuserregistration")
    public SaveDataUserRegisterResponse saveDataUserRegister(@RequestBody SaveDataUserRegisterRequest request){
        return userManagementService.saveDataUserRegister(request);
    }

    @PostMapping("/setpasswordandmpin")
    public SetPasswordResponse setPasswordAndMpin(@RequestBody SetPasswordRequest request) {
        return myAccountService.setPasswordAndMpin(request);
    }
}
