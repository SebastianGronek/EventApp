package com.example.demo.api;

import com.example.demo.model.Location;
import com.example.demo.services.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Validated
@RestController()
public class LocationController {
    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(path = "/locations")
    public ResponseEntity<Location> addLocation(@Valid @RequestBody Location location) {
        Location savedLocation = locationService.saveNewLocation(location);
        return ResponseEntity.created(URI.create("/locations" + "/" + savedLocation)).build();
    }

    @GetMapping(path = "/allLocations")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable long id) {
        Location location = locationService.getLocationById(id);
        return ResponseEntity.ok(location);
    }

}
