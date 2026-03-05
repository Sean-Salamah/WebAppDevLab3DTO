package com.example.lab3.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "location")
@NoArgsConstructor
@Entity

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    String city;

    @OneToMany(mappedBy = "location")
    @JsonManagedReference
    private List<Restaurant> restaurants;


}
