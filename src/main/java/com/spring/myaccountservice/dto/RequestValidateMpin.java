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
public class RequestValidateMpin implements Serializable {
    private static final long serialVersionUID = -7148100355393696091L;

    private String username;
    private String mpin;
}
