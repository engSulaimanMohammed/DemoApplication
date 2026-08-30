package com.cl.demo.controllers;


import com.cl.demo.entities.Person;
import com.cl.demo.requestobjects.PersonCreateRequest;
import com.cl.demo.requestobjects.PersonUpdateRequest;
import com.cl.demo.responseobjects.PersonCreateResponse;
import com.cl.demo.responseobjects.PersonUpdateResponse;
import com.cl.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    public PersonService personService;

    @PostMapping("add")
    public Map<String, String> addPerson(@RequestBody PersonCreateRequest person) {
        return personService.addPerson(person);
    }

    @GetMapping("getById")
    public PersonCreateResponse getPersonById(@RequestParam String uuid) {
        Person person = personService.getPersonById(uuid);
        if (person == null) {
            return null;
        }
        return PersonCreateResponse.convert(person);
    }
    @GetMapping("getAll")
    public List<PersonCreateResponse> getAllPerson() {
        return PersonCreateResponse.convert(personService.getAllPersons());
    }


    @PutMapping("update")
    public PersonUpdateResponse updatePerson(@RequestBody PersonUpdateRequest updateObj) {
        return PersonUpdateResponse.covert(personService.updatePerson(updateObj));
    }

    @DeleteMapping("deleteById")
    public Boolean deletePersonById(
            @RequestParam String id) {
        return personService.deleteById(id);
    }
}