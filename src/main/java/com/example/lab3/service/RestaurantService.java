package com.example.lab3.service;

import com.example.lab3.domain.Category;
import com.example.lab3.domain.Restaurant;
import com.example.lab3.repository.CategoryRepository;
import com.example.lab3.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final CategoryRepository categoryRepository;



    public RestaurantService(RestaurantRepository restaurantRepository, CategoryRepository categoryRepository) {
        this.restaurantRepository = restaurantRepository;
        this.categoryRepository = categoryRepository;
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

}
