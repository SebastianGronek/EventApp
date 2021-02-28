package com.example.demo.services;

import com.example.demo.dao.LocationRepository;
import com.example.demo.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location saveNewLocation(Location location) {
        return locationRepository.save(location);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(long id) {
        return locationRepository.getOne(id);
    }
}
