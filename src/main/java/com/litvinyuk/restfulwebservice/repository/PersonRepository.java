package com.litvinyuk.restfulwebservice.repository;

import com.litvinyuk.restfulwebservice.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findById (long id);
}
