package com.example.lab3.api;

import com.example.lab3.DTOs.UpdateRestaurantRequest;
import com.example.lab3.domain.Restaurant;
import com.example.lab3.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;
    public RestaurantController(RestaurantService restaurantService)
    {
        this.restaurantService=restaurantService;
    }
    @GetMapping
    public List<Restaurant> getAllRestaurants()
    {
        return restaurantService.getAllRestaurants();
    }

    @PatchMapping("/{id}")
    public Restaurant updateRestaurant(
            @PathVariable Long id,
            @RequestBody UpdateRestaurantRequest req) {

        return restaurantService.updateRestaurant(id, req);
    }

}
