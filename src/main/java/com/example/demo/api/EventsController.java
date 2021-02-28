package com.example.demo.api;

import com.example.demo.model.Event;
import com.example.demo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Validated
@RestController
public class EventsController {

    @Autowired
    EventService eventService;

    @RequestMapping("/addEvent")
    public String addEvent1(Event event) {
        return "event.html";
    }

    @PostMapping(path = "/events")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event savedEvent = eventService.saveNewEvent(event);
        return ResponseEntity.created(URI.create("/events" + "/" + savedEvent)).build();
    }

    @GetMapping("/allEvents")
    public ResponseEntity<List<Event>> events() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

   /* @DeleteMapping()
    public ResponseEntity<Event> deleteEvent(long id) {
        Event event = eventService.getEventById(id);
        return
    }*/
}
