package com.example.lab3.service;

import com.example.lab3.DTOs.UpdateRestaurantRequest;
import com.example.lab3.domain.Category;
import com.example.lab3.domain.Location;
import com.example.lab3.domain.Restaurant;
import com.example.lab3.repository.CategoryRepository;
import com.example.lab3.repository.LocationRepository;
import com.example.lab3.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final CategoryRepository categoryRepository;

    private final LocationRepository locationRepository;




    public RestaurantService(RestaurantRepository restaurantRepository, CategoryRepository categoryRepository, LocationRepository locationRepository) {
        this.restaurantRepository = restaurantRepository;
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
    }

    public Restaurant createRestaurant(Restaurant restaurant, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Link the restaurant to the category
        restaurant.setCategory(category);

        // Save the restaurant (the owning side)
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants()
    {
        return restaurantRepository.findAll();
    }

    public Restaurant updateRestaurant(Long restaurantId, UpdateRestaurantRequest req) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

// ensure location exists
        Location location = locationRepository.findById(req.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location not found"));

// enforce "update by location" (restaurant must belong to that location)
        if (!restaurant.getLocation().getLocationId().equals(location.getLocationId())) {
            throw new RuntimeException("Restaurant does not belong to the given location");
        }

// update fields (only if provided)
        if (req.getName() != null) restaurant.setName(req.getName());
        if (req.getPhone() != null) restaurant.setPhone(req.getPhone());

        return restaurantRepository.save(restaurant);
    }


}
