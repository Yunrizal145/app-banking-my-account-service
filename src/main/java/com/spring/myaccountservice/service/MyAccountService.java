package com.spring.myaccountservice.service;

import com.spring.myaccountmanagementservice.dto.SaveUserAccountRequest;
import com.spring.myaccountservice.dto.RequestListTransactionHistory;
import com.spring.myaccountservice.dto.RequestValidateMpin;
import com.spring.transactionhistorymanagementservice.dto.GetListTransactionHistoryRequest;
import com.spring.transactionhistorymanagementservice.dto.GetListTransactionHistoryResponse;
import com.spring.usermanagementservice.dto.GetUserAuthenticationRequest;
import com.spring.usermanagementservice.dto.GetUserFavoriteResponse;
import com.spring.usermanagementservice.dto.GetUserProfileRequest;
import com.spring.usermanagementservice.dto.SetPasswordRequest;
import com.spring.usermanagementservice.dto.SetPasswordResponse;
import com.spring.usermanagementservice.dto.ValidateMpinRequest;
import com.spring.usermanagementservice.dto.ValidateMpinResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class MyAccountService {

    @Autowired
    private UserManagementService userManagementService;

    @Autowired
    private MyAccountManagementService myAccountManagementService;

    @Autowired
    private TransactionHistoryManagementService transactionHistoryManagementService;

    public SetPasswordResponse setPasswordAndMpin(SetPasswordRequest request){
        log.info("setPasswordAndMpin start ... ");
        SetPasswordResponse setPasswordResponse = new SetPasswordResponse();
        try {
            var setPassword = userManagementService.setPasswordAndMpin(request);
            log.info("userData when set pass : {}", setPassword.getUserData());
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

    public GetListTransactionHistoryResponse getListTransactionHistoryResponse(RequestListTransactionHistory request){
        log.info("start getListTransactionHistory");
        log.info("start getListTransactionHistory request : {}", request);
        GetListTransactionHistoryResponse getListTransactionHistory = null;
        try {
            var getUserAuth = userManagementService.getUserAuthenticationByUsername(GetUserAuthenticationRequest.builder()
                    .username(request.getUsername())
                    .build());

            if (Objects.nonNull(getUserAuth.getUserAuthentication())) {
                var userAuth = getUserAuth.getUserAuthentication();
                getListTransactionHistory = transactionHistoryManagementService.getListTransactionHistoryResponse(GetListTransactionHistoryRequest.builder()
                                .userProfileId(userAuth.getId())
                        .build());
                log.info("list Data : {}", getListTransactionHistory);
                return getListTransactionHistory;
            }
            return getListTransactionHistory;
        } catch (Exception e) {
            throw new RuntimeException("error when get list transaction : {}", e);
        }
    }

    public GetUserFavoriteResponse getuserFavorite(RequestListTransactionHistory request){
        log.info("start getListTransactionHistory");
        log.info("start getListTransactionHistory request : {}", request);
        GetUserFavoriteResponse getUserFavoriteResponse = new GetUserFavoriteResponse();
        try {
            var getUserAuth = userManagementService.getUserAuthenticationByUsername(GetUserAuthenticationRequest.builder()
                    .username(request.getUsername())
                    .build());

            if (Objects.nonNull(getUserAuth.getUserAuthentication())) {
                var userAuth = getUserAuth.getUserAuthentication();
                getUserFavoriteResponse = userManagementService.getUserFavorite(GetUserProfileRequest.builder()
                                .userProfileId(userAuth.getId())
                                .bankName(request.getBankName())
                        .build());
                log.info("userFavorite data : {}", getUserFavoriteResponse);
                return getUserFavoriteResponse;
            }

            return getUserFavoriteResponse;
        } catch (Exception e) {
            throw new RuntimeException("error when get user favorite: {}", e);
        }
    }

    public ValidateMpinResponse validateMpin(RequestValidateMpin requestValidateMpin){
        log.info("start validateMpin ... ");
        log.info("start validateMpin req : {}", requestValidateMpin);
        ValidateMpinResponse validateMpinResponse = new ValidateMpinResponse();
        try {
            var getUserAuth = userManagementService.getUserAuthenticationByUsername(GetUserAuthenticationRequest.builder()
                    .username(requestValidateMpin.getUsername())
                    .build());
            if (Objects.nonNull(getUserAuth.getUserAuthentication())) {
                var userAuth = getUserAuth.getUserAuthentication();
                validateMpinResponse = userManagementService.validateMpin(ValidateMpinRequest.builder()
                                .userProfileId(userAuth.getId())
                                .mpin(requestValidateMpin.getMpin())
                        .build());

                return validateMpinResponse;
            }
            return validateMpinResponse;
        } catch (Exception e) {
            throw new RuntimeException("error when validate mpin", e);
        }
    }

}
