package com.pdeu.hackathon.citizen.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    private String location;

    @Min(value = -90, message = "Latitude must be between -90 and 90")
    @Max(value = 90, message = "Latitude must be between -90 and 90")
    private double latitude;
    private double longitude;


    private String type; // e.g., general, recyclable, organic
    private double percent;

    @NotNull(message = "Capacity cannot be null")
    @Min(value = 0, message = "Capacity must be greater than or equal to 0")
    private double capacity;
    private double currentLevel;

}

