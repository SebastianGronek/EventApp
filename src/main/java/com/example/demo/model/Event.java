package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private long id;
    private String name;


    private LocalDate date;
    @ManyToOne
    private Location location;
    @ManyToOne
    private Person organizer;
    @ManyToMany
    private List<Person> attendees;

    public Event(String name, LocalDate date, Location location, Person organizer) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.organizer = organizer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Person organizer) {
        this.organizer = organizer;
    }

    public List<Person> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Person> attendees) {
        this.attendees = attendees;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", location=" + location +
                ", organizer=" + organizer +
                ", attendees=" + attendees +
                '}';
    }
}
