package com.pdeu.hackathon.citizen.controller;

import com.pdeu.hackathon.citizen.dto.WasteBinDTO;
import com.pdeu.hackathon.citizen.entity.WasteBin;
import com.pdeu.hackathon.citizen.service.WasteBinService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wastebins")
public class WasteBinController {

    @Autowired
    private WasteBinService wasteBinService;

    @RequestMapping("/location")
    public ResponseEntity<WasteBinDTO> getWasteBinByLocation(@RequestParam("location") String location) {
        try {
            return ResponseEntity.ok(wasteBinService.getWasteBinByLocation(location));
        } catch(Exception exception)    {
            return ResponseEntity.badRequest().build();
//            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
        }

    }

    @RequestMapping("/location/custom")
    public ResponseEntity<List<WasteBinDTO>> getWasteBinByLocationCustom(@RequestParam("location") String location) {
        try {
            return ResponseEntity.ok(wasteBinService.getWasteBinsByLocationCustom(location));
        } catch(Exception exception)    {
            return ResponseEntity.badRequest().build();
//            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
        }

    }

    @RequestMapping("/latitude/{latitude}")
    public List<WasteBinDTO> getWasteBinByLatitude(@PathVariable("latitude") double latitude) {
        return wasteBinService.getWasteBinByLatitude(latitude);
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<WasteBinDTO>> getWasteBinByLatitude() {
        return ResponseEntity.ok(wasteBinService.getWasteBins());
    }

    @RequestMapping("/longitude")
    public WasteBinDTO getWasteBinByLongitude(double longitude) {
        return wasteBinService.getWasteBinByLongitude(longitude);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createWasteBin(@Valid @RequestBody WasteBinDTO wasteBinDTO) {
        try {
            return ResponseEntity.ok( wasteBinService.createWasteBin(wasteBinDTO));
        } catch (ValidationException ex) {
            return ResponseEntity.badRequest().body("Validation Exception");
        }
    }




}
