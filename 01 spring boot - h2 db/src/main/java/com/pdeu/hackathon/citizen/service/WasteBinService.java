package com.pdeu.hackathon.citizen.service;


import com.pdeu.hackathon.citizen.dto.WasteBinDTO;
import com.pdeu.hackathon.citizen.mapper.WasteBinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pdeu.hackathon.citizen.repository.WasteBinRepository;
import com.pdeu.hackathon.citizen.entity.WasteBin;

import java.util.List;

@Service
public class WasteBinService {


    private WasteBinRepository wasteBinRepository;



    @Autowired
    public WasteBinService(WasteBinRepository wasteBinRepository) {
        this.wasteBinRepository = wasteBinRepository;
    }


    public WasteBinDTO getWasteBinByLocation(String location) {
        return WasteBinMapper.toDTO(wasteBinRepository.findByLocation(location));
    }

    public List<WasteBinDTO> getWasteBinByLatitude(double latitude) {
        List<WasteBin> wasteBins = wasteBinRepository.findByLatitude(latitude);
        List<WasteBinDTO> wasteBinDTOs = WasteBinMapper.toDTOs(wasteBins);
        return wasteBinDTOs;
    }

    public WasteBinDTO getWasteBinByLongitude(double longitude) {
        WasteBin wasteBin = wasteBinRepository.findByLongitude(longitude);
        WasteBinDTO wasteBinDTO = WasteBinMapper.toDTO(wasteBin);
        return wasteBinDTO;
    }

    public WasteBinDTO createWasteBin(WasteBinDTO wasteBinDTO) {
        WasteBin wasteBin = WasteBinMapper.toEntity(wasteBinDTO);
        wasteBin = wasteBinRepository.save(wasteBin);
        return WasteBinMapper.toDTO(wasteBin);
    }



}
