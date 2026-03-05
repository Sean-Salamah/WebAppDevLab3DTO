package com.example.lab3.service;

import com.example.lab3.domain.Location;
import com.example.lab3.domain.Restaurant;
import com.example.lab3.repository.LocationRepository;
import com.example.lab3.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LocationService {
    private final LocationRepository locationRepository;
    private final RestaurantRepository restaurantRepository;


    public LocationService(LocationRepository locationRepository, RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
        this.locationRepository = locationRepository;
    }

    public List<Restaurant> findRestaurantsByLocation(Long locationId) {
        // Query the restaurants directly via the repo we fixed in Step 1
        return restaurantRepository.findByLocation(locationId);
    }

    public Location updateLocation(Long id, Location updatedLocation) {

        Location existingLocation = locationRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));

        existingLocation.setCity(updatedLocation.getCity());

        return locationRepository.save(existingLocation);
    }

}

