package com.pdeu.hackathon.citizen.service;

import com.pdeu.hackathon.citizen.dto.WasteBinDTO;
import com.pdeu.hackathon.citizen.entity.WasteBin;
import com.pdeu.hackathon.citizen.mapper.WasteBinMapper;
import com.pdeu.hackathon.citizen.repository.WasteBinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WasteBinService {

    private WasteBinRepository wasteBinRepository;

    @Autowired
    public WasteBinService(WasteBinRepository wasteBinRepository) {
        this.wasteBinRepository = wasteBinRepository;
    }

    @Transactional(readOnly = true)
    public WasteBinDTO getWasteBinByLocation(String location) {
        return WasteBinMapper.toDTO(wasteBinRepository.findByLocation(location));
    }

    @Transactional(readOnly = true)
    public List<WasteBinDTO> getWasteBinsByLocationCustom(String location) {
        return WasteBinMapper.toDTOs(wasteBinRepository.getByLocationNative(location));
    }

    @Transactional(readOnly = true)
    public List<WasteBinDTO> getWasteBinByLatitude(double latitude) {
        List<WasteBin> wasteBins = wasteBinRepository.findByLatitude(latitude);
        List<WasteBinDTO> wasteBinDTOs = WasteBinMapper.toDTOs(wasteBins);
        return wasteBinDTOs;
    }

    @Transactional(readOnly = true)
    public WasteBinDTO getWasteBinByLongitude(double longitude) {
        WasteBin wasteBin = wasteBinRepository.findByLongitude(longitude);
        WasteBinDTO wasteBinDTO = WasteBinMapper.toDTO(wasteBin);
        return wasteBinDTO;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public WasteBinDTO createWasteBin(WasteBinDTO wasteBinDTO) {
        WasteBin wasteBin = WasteBinMapper.toEntity(wasteBinDTO);
        wasteBin = wasteBinRepository.save(wasteBin);
        return WasteBinMapper.toDTO(wasteBin);
    }

    @Transactional(readOnly = true, timeout = 5000)
    public List<WasteBinDTO> getWasteBins() {
        return WasteBinMapper.toDTOs(wasteBinRepository.findAll());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createWasteBinWithNewTransaction(WasteBinDTO wasteBinDTO) {
        WasteBin wasteBin = WasteBinMapper.toEntity(wasteBinDTO);
        wasteBin = wasteBinRepository.save(wasteBin);
    }

    @Transactional
    public void createMultipleWasteBins(List<WasteBinDTO> wasteBinDTOs) {
        for (WasteBinDTO wasteBinDTO : wasteBinDTOs) {
            createWasteBin(wasteBinDTO);
        }
    }

    @Transactional
    public void createMultipleWasteBinsWithNewTransactions(List<WasteBinDTO> wasteBinDTOs) {
        for (WasteBinDTO wasteBinDTO : wasteBinDTOs) {
            createWasteBinWithNewTransaction(wasteBinDTO);
        }
    }
}