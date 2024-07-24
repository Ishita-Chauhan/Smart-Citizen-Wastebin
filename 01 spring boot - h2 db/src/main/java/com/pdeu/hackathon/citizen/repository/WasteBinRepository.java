package com.pdeu.hackathon.citizen.repository;

import com.pdeu.hackathon.citizen.dto.WasteBinDTO;
import com.pdeu.hackathon.citizen.entity.WasteBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WasteBinRepository extends JpaRepository<WasteBin, Long> {
    WasteBin findByLocation(String location);

    List<WasteBin> findByLatitude(double latitude);

    WasteBin findByLongitude(double longitude);

    WasteBin findByType(String type);

    WasteBin findByCapacity(double capacity);
}
