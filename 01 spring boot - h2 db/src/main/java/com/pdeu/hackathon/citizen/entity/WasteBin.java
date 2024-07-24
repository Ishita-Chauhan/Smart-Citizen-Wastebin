package com.pdeu.hackathon.citizen.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WasteBin {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String location;
    private double latitude;
    private double longitude;
    private String type; // e.g., general, recyclable, organic
    private double capacity;
    private double currentLevel;


}
