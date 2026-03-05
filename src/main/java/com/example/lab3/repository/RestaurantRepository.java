package com.example.lab3.repository;

import com.example.lab3.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Long, Restaurant> {
}
