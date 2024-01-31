package com.imaginnovate.CustomerSupport.controller;

import com.imaginnovate.CustomerSupport.dto.ResponseDTO;
import com.imaginnovate.CustomerSupport.service.CustomerSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customersupport")
public class CustomerSupportController {

    @Autowired
    CustomerSupportService customerSupportService;

    @PutMapping
    public ResponseEntity<ResponseDTO> sendMessage(@RequestParam("message") String message) {
        System.out.println("Customer Support:- " + message);
        boolean status = customerSupportService.sendMessageToCustomer(message);
        if (!status){
            return ResponseEntity.badRequest().body(new ResponseDTO("Message not delivered"));
        }
        return ResponseEntity.ok(new ResponseDTO("Message delivered succesfully"));
    }

}
