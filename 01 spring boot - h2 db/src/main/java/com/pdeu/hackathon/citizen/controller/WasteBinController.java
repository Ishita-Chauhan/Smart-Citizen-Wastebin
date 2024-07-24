package com.pdeu.hackathon.citizen.controller;

import com.pdeu.hackathon.citizen.dto.WasteBinDTO;
import com.pdeu.hackathon.citizen.entity.WasteBin;
import com.pdeu.hackathon.citizen.service.WasteBinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wastebins")
public class WasteBinController {

    @Autowired
    private WasteBinService wasteBinService;

    @RequestMapping("/location")
    public WasteBinDTO getWasteBinByLocation(@RequestParam("location") String location) {
        return wasteBinService.getWasteBinByLocation(location);
    }

    @RequestMapping("/latitude/{latitude}")
    public List<WasteBinDTO> getWasteBinByLatitude(@PathVariable("latitude") double latitude) {
        return wasteBinService.getWasteBinByLatitude(latitude);
    }

    @RequestMapping("/longitude")
    public WasteBinDTO getWasteBinByLongitude(double longitude) {
        return wasteBinService.getWasteBinByLongitude(longitude);
    }

    @PostMapping("/create")
    public WasteBinDTO createWasteBin(@RequestBody WasteBinDTO wasteBinDTO) {

        return wasteBinService.createWasteBin(wasteBinDTO);
    }




}
