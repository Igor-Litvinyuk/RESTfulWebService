package com.litvinyuk.restfulwebservice.service;

import com.litvinyuk.restfulwebservice.domain.Person;
import com.litvinyuk.restfulwebservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person findPersonById(long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person savePerson(Map<String, String> body) {
        Person person = new Person();
        person.setFirstName(body.get("firstName"));
        person.setLastName(body.get("lastName"));
        person.setDateOfBirth(body.get("dateOfBirth"));
        person.setPostalCode(body.get("postalCode"));
        person.setPicture(body.get("picture"));
        return personRepository.save(person);
    }

    @Override
    public Person updatePersonById(long id, Map<String, String> body) {
        Person person = personRepository.findById(id);
        person.setFirstName(body.get("firstName"));
        person.setLastName(body.get("lastName"));
        person.setDateOfBirth(body.get("dateOfBirth"));
        person.setPostalCode(body.get("postalCode"));
        person.setPicture(body.get("picture"));
        return personRepository.save(person);
    }

    @Override
    public void deletePersonById(long id) {
        personRepository.deleteById(id);
    }

}
