package com.spring.myaccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestListTransactionHistory implements Serializable {
    private static final long serialVersionUID = -1606084738305214656L;

    private String username;
    private String bankName;
}
