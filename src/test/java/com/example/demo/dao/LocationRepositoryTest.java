package com.example.demo.dao;

import com.example.demo.model.Location;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocationRepositoryTest {

    @Autowired
    private LocationRepository locationRepository;

    @Test
    void shouldSaveNewLocation() {
        //given
        //when
        Location savedLocation = locationRepository.save(new Location("kwadrat", "jakis adres"));
        //then
        assertNotNull(savedLocation.getId());
    }
}