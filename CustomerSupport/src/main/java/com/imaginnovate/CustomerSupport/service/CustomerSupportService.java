package com.imaginnovate.CustomerSupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerSupportService {

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;

    @KafkaListener(topics = "customer-messages", groupId = "customer-group")
    public void printCustomerMessages(String message){
        System.out.println("Customer:- " + message);
    }

    public boolean sendMessageToCustomer(String message){
        kafkaTemplate.send("customer-support-messages", message);
        return true;
    }

}
