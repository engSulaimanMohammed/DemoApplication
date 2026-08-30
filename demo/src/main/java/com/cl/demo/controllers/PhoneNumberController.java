package com.cl.demo.controllers;

import com.cl.demo.entities.PhoneNumber;
import com.cl.demo.requestobjects.PhoneNumberCreateRequest;
import com.cl.demo.responseobjects.PhoneNumberCreateResponse;
import com.cl.demo.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // This class means it accepts Web/API requests.
@RequestMapping("phoneNumber") // The primary title of this Controller.
public class PhoneNumberController {

    @Autowired // To use PhoneNumberService inside Controller.
    PhoneNumberService phoneNumberService;

    @PostMapping("/add") // will be POST /phoneNumber/add.
    public PhoneNumberCreateResponse addPhoneNumber(@RequestBody PhoneNumberCreateRequest requestObj) {
        // The data the user sends is sent inside PhoneNumberCreateRequest
        PhoneNumber phoneNumber = phoneNumberService.addPhoneNumber(requestObj);
        return PhoneNumberCreateResponse.convert(phoneNumber);
    }
}