package com.cl.demo.controllers;

import com.cl.demo.entities.PhoneNumber;
import com.cl.demo.requestobjects.PhoneNumberCreateRequest;
import com.cl.demo.requestobjects.PhoneNumberUpdateRequest;
import com.cl.demo.responseobjects.PhoneNumberCreateResponse;
import com.cl.demo.responseobjects.PhoneNumberUpdateResponse;
import com.cl.demo.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @GetMapping("/getById")
    public PhoneNumberCreateResponse getPhoneNumberById(@RequestParam String uuid) {
        PhoneNumber phoneNumber = phoneNumberService.getPhoneNumberById(uuid);
        return PhoneNumberCreateResponse.convert(phoneNumber);
    }

    @GetMapping("/getAll")
    public List<PhoneNumberCreateResponse> getAllPhoneNumbers() {
        List<PhoneNumber> phoneNumbers = phoneNumberService.getAllPhoneNumbers();
        return PhoneNumberCreateResponse.convert(phoneNumbers);
    }

    @PutMapping("/update")
    public PhoneNumberUpdateResponse updatePhoneNumber(@RequestBody PhoneNumberUpdateRequest updateObj) {
        PhoneNumber phoneNumber = phoneNumberService.updatePhoneNumber(updateObj);
        return PhoneNumberUpdateResponse.convert(phoneNumber);
    }

    @DeleteMapping("/deleteById")
    public Boolean deletePhoneNumberById(@RequestParam String id) {
        return phoneNumberService.deleteById(id);
    }


}