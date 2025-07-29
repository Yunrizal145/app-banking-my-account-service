package com.spring.myaccountservice.service;

import com.spring.transactionhistorymanagementservice.dto.GetListTransactionHistoryRequest;
import com.spring.transactionhistorymanagementservice.dto.GetListTransactionHistoryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class TransactionHistoryManagementService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.getListTransactionHistory}")
    private String getListTransactionHistoryUrl;

    public GetListTransactionHistoryResponse getListTransactionHistoryResponse(GetListTransactionHistoryRequest request){
        log.info("Start getListTransactionHistory ... ");
        log.info("getListTransactionHistory request : {}", request);

        ResponseEntity<GetListTransactionHistoryResponse> getListTransactionHistory = restTemplate.postForEntity(getListTransactionHistoryUrl, request, GetListTransactionHistoryResponse.class);
        return getListTransactionHistory.getBody();
    }
}
