package com.example.lab3.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "restaurant")
@NoArgsConstructor
@Entity
public class Restaurant {

    @Id
    private Long restaurantId;

    private String restaurantName;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Category category;

}
