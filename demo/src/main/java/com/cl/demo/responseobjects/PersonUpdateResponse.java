package com.cl.demo.responseobjects;


import com.cl.demo.entities.Person;
import com.cl.demo.requestobjects.PersonUpdateRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonUpdateResponse {

    String personId;
    String userName;
    String email;


    public static PersonUpdateResponse covert(Person person) {
        PersonUpdateResponse response = new PersonUpdateResponse();
        response.setPersonId(person.getId().toString());
        response.setUserName(person.getUserName().getActiveUserName());
        response.setEmail(person.getEmail());
        return response;
    }

    public static List<PersonUpdateResponse> convert(List<Person> personList) {
        List<PersonUpdateResponse> responseList = new ArrayList<>();
        for (Person p : personList) {
            responseList.add(covert(p));
        }
        return responseList;
    }
}
