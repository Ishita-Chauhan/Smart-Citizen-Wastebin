package com.pdeu.hackathon.citizen.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WasteBinDTO {

    private Long id;
    private String location;
    private double latitude;
    private double longitude;
    private String type; // e.g., general, recyclable, organic
    private double percent;
    private double capacity;
    private double currentLevel;

}

