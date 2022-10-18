package com.hcx.hcxprovider.controllers;

import com.hcx.hcxprovider.dto.PreAuthReqDTO;
import com.hcx.hcxprovider.model.PreAuthRequest;
import com.hcx.hcxprovider.repository.PreAuthRequestRepo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class preAuthRequestController {
    @Value("${queue.name}")
    String queueName;

    @Value("${queue.exchange}")
    String exchange;

    @Value("${queue.routingKey}")
    private String routingkey;

    @Autowired
    PreAuthRequestRepo preAuthRequestRepo;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping(value = "/savePreAuthReq")
    public String savePreAuthRequest(@RequestBody PreAuthRequest preAuthRequest){
        preAuthRequestRepo.save(preAuthRequest);
        PreAuthReqDTO preAuthReqDTO = new PreAuthReqDTO(preAuthRequest.getId(),preAuthRequest.getHospital_id());
        System.out.println(preAuthReqDTO);
        rabbitTemplate.convertAndSend(exchange,routingkey,preAuthReqDTO);
        return preAuthRequest.getId();

    }

}
