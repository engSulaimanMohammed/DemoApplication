package com.cl.demo.requestobjects;


import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter

public class PhoneNumberUpdateRequest {
    private UUID uuid; // Specify which phone number we want to edit.
    private String countryCodeToUpdate;
    private Long phoneNumberToUpdate;
}
