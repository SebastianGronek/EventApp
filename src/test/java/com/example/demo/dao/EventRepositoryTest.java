package com.example.demo.dao;

import com.example.demo.model.Event;
import com.example.demo.model.Location;
import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private PersonRepository personRepository;

    @Test
    void should() {
        //given
        Location location = locationRepository.save(new Location("moj dom", "gdzies"));
        Person person = personRepository.save(new Person("ja"));
        //when
        Event event = eventRepository.save(new Event("Kurs", LocalDate.now().plusDays(1), location, person));
        //then
        assertNotNull(event.getId());
    }
}