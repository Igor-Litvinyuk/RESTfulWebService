package com.litvinyuk.restfulwebservice.controller;

import com.litvinyuk.restfulwebservice.domain.Person;
import com.litvinyuk.restfulwebservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    private final PersonService personService;

    @Autowired
    public MainController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> getAllPersons(){
        return personService.findAllPersons();
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable String id){
        return personService.findPersonById(Long.parseLong(id));
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public Person savePerson(@RequestBody Map<String, String> body){
        return personService.savePerson(body);
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.PUT)
    public Person updatePerson(@PathVariable String id, @RequestBody Map<String, String> body){
        return personService.updatePersonById(Long.parseLong(id), body);
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable String id){
        personService.deletePersonById(Long.parseLong(id));
    }
}
