package com.hcx.hcxprovider.model;

import com.hcx.hcxprovider.dto.PreAuthDetails;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "preAuthRequests")
@AllArgsConstructor
public class PreAuthRequest {
@Id
    private String id;
    private String hospital_id;
    private PreAuthDetails preAuthReq;

    public String getId() {
        return id;
    }
    public String getHospital_id() {
        return hospital_id;
    }

    public PreAuthDetails getPreAuthReq() {
        return preAuthReq;
    }

    public void setPreAuthReq(PreAuthDetails preAuthReq) {
        this.preAuthReq = preAuthReq;
    }

    public void setHospital_id(String hospital_id) {
        this.hospital_id = hospital_id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
