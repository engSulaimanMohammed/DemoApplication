package com.cl.demo.services;

import com.cl.demo.DemoApplication;
import com.cl.demo.entities.PhoneNumber;
import com.cl.demo.requestobjects.PhoneNumberCreateRequest;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.UUID;
import com.cl.demo.requestobjects.PhoneNumberUpdateRequest;
import com.cl.demo.utils.HelperUtils;

@Service
public class PhoneNumberService {
    public PhoneNumber addPhoneNumber(PhoneNumberCreateRequest requestObj) {
        PhoneNumber phoneNumber = new PhoneNumber();

        phoneNumber.setId(UUID.randomUUID());
        phoneNumber.setIsActive(Boolean.TRUE);
        phoneNumber.setCreatedDate(new Date());
        phoneNumber.setCountryCode(requestObj.getCountryCode());
        phoneNumber.setPhoneNumber(requestObj.getPhoneNumber());
        DemoApplication.PhoneNumber_List.add(phoneNumber);
        return phoneNumber;
    }

    public PhoneNumber getPhoneNumberById(String uuid) {  // search the phone num by ID.
        for (PhoneNumber p : DemoApplication.PhoneNumber_List) { // check from PhoneNumber_List and add to p.
            if (p.getId().toString().equals(uuid) && p.getIsActive()) { // if the num equal and active.
                return p; // return the num.
            }
        }
        return null; // if not equal return new phone num.
    }

    public List<PhoneNumber> getAllPhoneNumbers() {
        List<PhoneNumber> resultList = new ArrayList<>(); // create new empty list.
        for (PhoneNumber p : DemoApplication.PhoneNumber_List) { // It goes through all the phone numbers.
            if (p.getIsActive()) { // check if the num active.
                resultList.add(p);  // He adds it to the list of results.
            }
        }
        return resultList;  // All active phone numbers are returned.
    }


    public PhoneNumber updatePhoneNumber(PhoneNumberUpdateRequest updateObj) {
        PhoneNumber phoneNumber = getPhoneNumberById(updateObj.getUuid().toString());  // search the phone num.
        if (phoneNumber == null || phoneNumber.getId() == null || !phoneNumber.getIsActive()) { // If the number is not found or is not active, we stop the update.
            return phoneNumber;
        }
        DemoApplication.PhoneNumber_List.remove(phoneNumber);
        phoneNumber.setCountryCode(HelperUtils.compare(phoneNumber.getCountryCode(), updateObj.getCountryCodeToUpdate()));
        phoneNumber.setPhoneNumber(HelperUtils.compare(phoneNumber.getPhoneNumber(), updateObj.getPhoneNumberToUpdate()));
        phoneNumber.setUpdatedDate(new Date());
        DemoApplication.PhoneNumber_List.add(phoneNumber);
        return phoneNumber;
    }



    public Boolean deleteById(String uuid) {
        PhoneNumber phoneNumber = getPhoneNumberById(uuid);
        if (phoneNumber == null || phoneNumber.getId() == null || !phoneNumber.getIsActive()) {
            return false;
        } else {
            DemoApplication.PhoneNumber_List.remove(phoneNumber);
            phoneNumber.setIsActive(false);
            DemoApplication.PhoneNumber_List.add(phoneNumber);
            return true;
        }
    }
}