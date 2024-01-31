package com.imaginnovate.Customer.controller;

import com.imaginnovate.Customer.dto.ResponseDTO;
import com.imaginnovate.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PutMapping
    public ResponseEntity<ResponseDTO> sendMessage(@RequestParam("message") String message) {
        System.out.println("Customer:- " + message);
        boolean status = customerService.sendMessageToCustomerSupport(message);
        if (!status){
            return  ResponseEntity.badRequest().body(new ResponseDTO("Message not delivered"));
        }
        return ResponseEntity.ok(new ResponseDTO("Message delivered succesfully"));
    }
}
