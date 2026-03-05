package com.example.lab3.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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

    private String Name;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id")
    private Category category;

    private String phone;

}
