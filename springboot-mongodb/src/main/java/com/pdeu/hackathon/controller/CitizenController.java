package com.pdeu.hackathon.controller;

import com.pdeu.hackathon.entity.Citizen;
import com.pdeu.hackathon.service.CitizenService;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citizens")
public class CitizenController {

    @Autowired
    CitizenService citizenService;


    @PostMapping
    public ResponseEntity<Citizen> createCitizen(@RequestParam String name, @RequestParam String mobileNumber, @RequestParam String emailId) {
        return ResponseEntity.ok(citizenService.createCitizen(name, mobileNumber, emailId));
    }


    @GetMapping
    public ResponseEntity<List<Citizen>> getAllCitizens() {
        return ResponseEntity.ok(citizenService.getCitizens());
    }



}
