package com.imaginnovate.Customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;

    @KafkaListener(topics = "customer-support-messages", groupId = "customer-support-group")
    public void printCustomerMessages(String message){
        System.out.println("Customer Support:- " + message);
    }

    public boolean sendMessageToCustomerSupport(String message){
        kafkaTemplate.send("customer-messages", message);
        return true;
    }
}
