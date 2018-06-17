package com.litvinyuk.restfulwebservice.service;

import com.litvinyuk.restfulwebservice.domain.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {
    List<Person> findAllPersons();

    Person findPersonById(long id);

    Person savePerson(Map<String,String> body);

    Person updatePersonById(long id, Map<String,String> body);

    void deletePersonById(long id);
}
