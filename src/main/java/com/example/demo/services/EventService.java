package com.example.demo.services;

import com.example.demo.dao.EventRepository;
import com.example.demo.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event saveNewEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEventById(long id) {
        return eventRepository.getOne(id);
    }
}
