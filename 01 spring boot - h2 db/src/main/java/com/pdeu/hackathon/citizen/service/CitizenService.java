package com.pdeu.hackathon.citizen.service;

import com.pdeu.hackathon.citizen.entity.Citizen;
import com.pdeu.hackathon.citizen.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;


    public Citizen createCitizen(String name, String mobileNumber, String emailid) {
        Citizen c = new Citizen();
        c.setName(name);
        c.setEmail(emailid);
        c.setPhoneNumber(mobileNumber);
        return citizenRepository.save(c);
    }

    public List<Citizen> getCitizens() {
        return citizenRepository.findAll();
    }


}
