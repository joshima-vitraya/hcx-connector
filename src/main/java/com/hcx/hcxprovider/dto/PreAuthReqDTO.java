package com.hcx.hcxprovider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PreAuthReqDTO {
    private String reqId;
    private String hospitalId;
}
