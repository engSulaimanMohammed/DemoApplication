package com.cl.demo.responseobjects;

import com.cl.demo.entities.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PhoneNumberCreateResponse {
    String phoneNumberId;
    String countryCode;
    Long phoneNumber;

    public static PhoneNumberCreateResponse convert(PhoneNumber phoneNumber) { // convert one phone number.
        PhoneNumberCreateResponse response = new PhoneNumberCreateResponse();
        response.setPhoneNumberId(phoneNumber.getId().toString());
        response.setCountryCode(phoneNumber.getCountryCode());
        response.setPhoneNumber(phoneNumber.getPhoneNumber());
        return response;
    }
    public static List<PhoneNumberCreateResponse> convert(List<PhoneNumber> phoneNumberList) { // convert all phone number list.
        List<PhoneNumberCreateResponse> responseList = new ArrayList<>();
        for (PhoneNumber p : phoneNumberList) {
            responseList.add(convert(p));
        }
        return responseList;
    }
}