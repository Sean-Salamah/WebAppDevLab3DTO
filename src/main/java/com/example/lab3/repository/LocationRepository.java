package com.example.lab3.repository;

import com.example.lab3.domain.Location;
import com.example.lab3.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository <Location,Long> {


}
