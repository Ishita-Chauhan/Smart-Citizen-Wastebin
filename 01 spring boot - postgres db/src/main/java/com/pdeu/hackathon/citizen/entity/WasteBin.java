package com.pdeu.hackathon.citizen.entity;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "waste_bin")
@JacksonXmlRootElement(localName = "waste_bin")
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
