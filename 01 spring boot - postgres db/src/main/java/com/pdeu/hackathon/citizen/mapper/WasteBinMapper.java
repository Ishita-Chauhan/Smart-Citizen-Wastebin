package com.pdeu.hackathon.citizen.mapper;

import com.pdeu.hackathon.citizen.dto.WasteBinDTO;
import com.pdeu.hackathon.citizen.entity.WasteBin;

import java.util.ArrayList;
import java.util.List;

public class WasteBinMapper {

    public static List<WasteBinDTO> toDTOs(List<WasteBin> wasteBins) {
        if (wasteBins == null) {
            return null;
        }

        List<WasteBinDTO> wasteBinDTOs = new ArrayList<>();
        for(WasteBin bin : wasteBins) {
            WasteBinDTO wasteBinDTO = toDTO(bin);
            wasteBinDTOs.add(wasteBinDTO);
        }

        return wasteBinDTOs;

    }

    public static WasteBinDTO toDTO(WasteBin wasteBin) {
        if (wasteBin == null) {
            return null;
        }

        WasteBinDTO wasteBinDTO = new WasteBinDTO();
        wasteBinDTO.setId(wasteBin.getId());
        wasteBinDTO.setLocation(wasteBin.getLocation());
        wasteBinDTO.setLatitude(wasteBin.getLatitude());
        wasteBinDTO.setLongitude(wasteBin.getLongitude());
        wasteBinDTO.setType(wasteBin.getType());
        wasteBinDTO.setCapacity(wasteBin.getCapacity());
        wasteBinDTO.setCurrentLevel(wasteBin.getCurrentLevel());
        wasteBinDTO.setPercent((wasteBin.getCurrentLevel() *100) / (wasteBin.getCapacity()));

        return wasteBinDTO;
    }

    public static WasteBin toEntity(WasteBinDTO wasteBinDTO) {
        if (wasteBinDTO == null) {
            return null;
        }

        WasteBin wasteBin = new WasteBin();
        wasteBin.setId(wasteBinDTO.getId());
        wasteBin.setLocation(wasteBinDTO.getLocation());
        wasteBin.setLatitude(wasteBinDTO.getLatitude());
        wasteBin.setLongitude(wasteBinDTO.getLongitude());
        wasteBin.setType(wasteBinDTO.getType());
        wasteBin.setCapacity(wasteBinDTO.getCapacity());
        wasteBin.setCurrentLevel(wasteBinDTO.getCurrentLevel());

        return wasteBin;
    }
}

