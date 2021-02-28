package com.example.demo.dao;

import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void shouldSavePerson() {
        //given

        //when
        Person savedPerson = personRepository.save(new Person("Jan"));
        //then
        assertNotNull(savedPerson.getId());
    }
}