package com.cl.demo.responseobjects;


import com.cl.demo.entities.PhoneNumber;
import java.util.ArrayList;
import java.util.List;
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

    public static List<PhoneNumberUpdateResponse> convert(List<PhoneNumber> phoneNumberList) {
        List<PhoneNumberUpdateResponse> responseList = new ArrayList<>();
        for (PhoneNumber p : phoneNumberList) {
            responseList.add(convert(p));
        }
        return responseList;
    }
}
