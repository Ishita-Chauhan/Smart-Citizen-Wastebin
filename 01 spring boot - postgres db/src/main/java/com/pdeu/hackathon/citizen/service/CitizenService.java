package com.pdeu.hackathon.citizen.service;

import com.pdeu.hackathon.citizen.dto.WasteBinDTO;
import com.pdeu.hackathon.citizen.entity.Citizen;
import com.pdeu.hackathon.citizen.repository.CitizenRepository;
import com.pdeu.hackathon.citizen.repository.WasteBinRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class CitizenService {

    @Autowired
    private WasteBinService wasteBinService;

    @Autowired
    private CitizenRepository citizenRepository;


    @Transactional
    public Citizen createCitizen(String name, String mobileNumber, String emailid) {

        wasteBinService.createWasteBin(new WasteBinDTO());

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
