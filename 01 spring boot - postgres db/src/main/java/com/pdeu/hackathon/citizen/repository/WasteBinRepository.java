package com.pdeu.hackathon.citizen.repository;

import com.pdeu.hackathon.citizen.dto.WasteBinDTO;
import com.pdeu.hackathon.citizen.entity.WasteBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WasteBinRepository extends JpaRepository<WasteBin, Long> {
    WasteBin findByLocation(String location);

    List<WasteBin> findByLatitude(double latitude);

    WasteBin findByLongitude(double longitude);

    WasteBin findByType(String type);

    WasteBin findByCapacity(double capacity);

    @Query("SELECT wb  FROM WasteBin wb WHERE wb.location = :location")
    List<WasteBin> getByLocation(@Param("location") String location);

    @Query(value = "SELECT * FROM waste_bin wb WHERE wb.location = :location", nativeQuery = true)
    List<WasteBin> getByLocationNative(@Param("location") String location);


    @Query("SELECT w FROM WasteBin w WHERE w.capacity BETWEEN :minCapacity AND :maxCapacity")
    List<WasteBin> findWasteBinsByCapacityRange(@Param("minCapacity") double minCapacity, @Param("maxCapacity") double maxCapacity);
}
