package com.cl.demo.responseobjects;


import com.cl.demo.entities.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PhoneNumberUpdateResponse {
    String phoneNumberId;
    String countryCode;
    Long phoneNumber;

    public static PhoneNumberUpdateResponse convert(PhoneNumber phoneNumber) {
        PhoneNumberUpdateResponse response = new PhoneNumberUpdateResponse();
        response.setPhoneNumberId(phoneNumber.getId().toString());
        response.setCountryCode(phoneNumber.getCountryCode());
        response.setPhoneNumber(phoneNumber.getPhoneNumber());
        return response;
    }
}
