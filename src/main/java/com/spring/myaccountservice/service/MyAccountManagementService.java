package com.spring.myaccountservice.service;

import com.spring.myaccountmanagementservice.dto.GetMutasiByAccountNumberRequest;
import com.spring.myaccountmanagementservice.dto.SaveAccountUserResponse;
import com.spring.myaccountmanagementservice.dto.SaveUserAccountRequest;
import com.spring.myaccountmanagementservice.model.AccountUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class MyAccountManagementService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.getAccountUser}")
    private String getAccountUserUrl;

    @Value("${url.saveAccountUser}")
    private String saveAccountUserUrl;

    public AccountUser getAccountUser(GetMutasiByAccountNumberRequest request) {
        log.info("Start getValueFromMyAccountMS ... ");
        log.info("getAccountUser ... ");

        ResponseEntity<AccountUser> getAccountUser = restTemplate.postForEntity(getAccountUserUrl, request, AccountUser.class);
        return getAccountUser.getBody();
    }

    public SaveAccountUserResponse saveAccountUser(SaveUserAccountRequest request) {
        log.info("Start getValueFromMyAccountMS ... ");
        log.info("saveAccountUser ... ");

        ResponseEntity<SaveAccountUserResponse> getAccountUser = restTemplate.postForEntity(saveAccountUserUrl, request, SaveAccountUserResponse.class);
        return getAccountUser.getBody();
    }


}
