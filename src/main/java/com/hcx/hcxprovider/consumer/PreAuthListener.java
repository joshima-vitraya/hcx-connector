package com.hcx.hcxprovider.consumer;

import com.hcx.hcxprovider.dto.PreAuthReqDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PreAuthListener {
    @RabbitListener(queues = "${queue.name}")
    public void consumeMessageFromQueue(PreAuthReqDTO preAuthReqDTO){

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8082/getPreAuthReq";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(preAuthReqDTO,headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
        System.out.println(answer);
    }
}
