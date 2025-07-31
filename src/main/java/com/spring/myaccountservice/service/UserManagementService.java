package com.spring.myaccountservice.service;

import com.spring.usermanagementservice.dto.GetUserAuthenticationRequest;
import com.spring.usermanagementservice.dto.GetUserAuthenticationResponse;
import com.spring.usermanagementservice.dto.GetUserFavoriteResponse;
import com.spring.usermanagementservice.dto.GetUserProfileRequest;
import com.spring.usermanagementservice.dto.GetUserProfileResponse;
import com.spring.usermanagementservice.dto.OtpRequest;
import com.spring.usermanagementservice.dto.OtpValidationRequest;
import com.spring.usermanagementservice.dto.OtpValidationResponse;
import com.spring.usermanagementservice.dto.SaveDataUserRegisterRequest;
import com.spring.usermanagementservice.dto.SaveDataUserRegisterResponse;
import com.spring.usermanagementservice.dto.SetPasswordRequest;
import com.spring.usermanagementservice.dto.SetPasswordResponse;
import com.spring.usermanagementservice.dto.ValidateMpinRequest;
import com.spring.usermanagementservice.dto.ValidateMpinResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserManagementService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.getUserProfile}")
    private String getUserProfileUrl;

    @Value("${url.getUserProfileById}")
    private String getUserProfileByIdUrl;

    @Value("${url.getUserAuthentication}")
    private String getUserAuthenticationUrl;

    @Value("${url.getUserAuthenticationByUsername}")
    private String getUserAuthenticationByUsernameUrl;

    @Value("${url.sendOtp}")
    private String sendOtpUrl;

    @Value("${url.otpValidate}")
    private String otpValidateUrl;

    @Value("${url.saveDataUserRegister}")
    private String saveDataUserRegisterUrl;

    @Value("${url.setPasswordAndMpin}")
    private String setPasswordAndMpinUrl;

    @Value("${url.getUserFavorite}")
    private String getUserFavoriteUrl;

    @Value("${url.validateMpin}")
    private String validateMpinUrl;

    public GetUserProfileResponse getUserProfile(GetUserProfileRequest request) {
        log.info("Start getValueFromUserMS ... ");
        log.info("getUserProfile ... ");

        ResponseEntity<GetUserProfileResponse> getUserProfile = restTemplate.postForEntity(getUserProfileUrl, request, GetUserProfileResponse.class);
        return getUserProfile.getBody();
    }

    public GetUserProfileResponse getUserProfileById(GetUserProfileRequest request) {
        log.info("Start getValueFromUserMS ... ");
        log.info("getUserProfile by id ... ");

        ResponseEntity<GetUserProfileResponse> getUserProfile = restTemplate.postForEntity(getUserProfileByIdUrl, request, GetUserProfileResponse.class);
        return getUserProfile.getBody();
    }

    public GetUserAuthenticationResponse getUserAuthentication(GetUserAuthenticationRequest request) {
        log.info("Start getValueFromUserMS ... ");
        log.info("getUserAuthentication ... ");

        ResponseEntity<GetUserAuthenticationResponse> getUserAuthentication = restTemplate.postForEntity(getUserAuthenticationUrl, request, GetUserAuthenticationResponse.class);
        return getUserAuthentication.getBody();
    }

    public GetUserAuthenticationResponse getUserAuthenticationByUsername(GetUserAuthenticationRequest request) {
        log.info("Start getValueFromUserMS ... ");
        log.info("getUserAuthentication by username ... ");

        ResponseEntity<GetUserAuthenticationResponse> getUserAuthentication = restTemplate.postForEntity(getUserAuthenticationByUsernameUrl, request, GetUserAuthenticationResponse.class);
        return getUserAuthentication.getBody();
    }

    public void sendOtp(OtpRequest request){
        log.info("Start getValueFromUserMS ... ");
        log.info("saveDataUserRegister ... ");

        restTemplate.postForEntity(sendOtpUrl, request, Void.class);
    }
    public OtpValidationResponse otpValidation(OtpValidationRequest request){
        log.info("Start getValueFromUserMS ... ");
        log.info("saveDataUserRegister ... ");

        ResponseEntity<OtpValidationResponse> otpValidation = restTemplate.postForEntity(otpValidateUrl, request, OtpValidationResponse.class);
        return otpValidation.getBody();
    }

    public SaveDataUserRegisterResponse saveDataUserRegister(SaveDataUserRegisterRequest request){
        log.info("Start getValueFromUserMS ... ");
        log.info("saveDataUserRegister ... ");

        ResponseEntity<SaveDataUserRegisterResponse> getUserAuthentication = restTemplate.postForEntity(saveDataUserRegisterUrl, request, SaveDataUserRegisterResponse.class);
        return getUserAuthentication.getBody();
    }

    public SetPasswordResponse setPasswordAndMpin(SetPasswordRequest request) {
        log.info("Start getValueFromUserMS ... ");
        log.info("getUserAuthentication by username ... ");

        ResponseEntity<SetPasswordResponse> getUserAuthentication = restTemplate.postForEntity(setPasswordAndMpinUrl, request, SetPasswordResponse.class);
        return getUserAuthentication.getBody();
    }

    public GetUserFavoriteResponse getUserFavorite(GetUserProfileRequest request) {
        log.info("Start getUserFavorite List ... ");
        log.info("Start getUserFavorite List req : {}", request);

        ResponseEntity<GetUserFavoriteResponse> getUserAuthentication = restTemplate.postForEntity(getUserFavoriteUrl, request, GetUserFavoriteResponse.class);
        return getUserAuthentication.getBody();
    }

    public ValidateMpinResponse validateMpin(ValidateMpinRequest request) {
        log.info("Start validateMpin ... ");
        log.info("Start validateMpin req : {}", request);

        ResponseEntity<ValidateMpinResponse> validateMpinEntity = restTemplate.postForEntity(getUserFavoriteUrl, request, ValidateMpinResponse.class);
        return validateMpinEntity.getBody();
    }
}
