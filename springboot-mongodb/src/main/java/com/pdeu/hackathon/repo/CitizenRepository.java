package com.pdeu.hackathon.repo;

import com.pdeu.hackathon.entity.Citizen;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CitizenRepository extends MongoRepository<Citizen, String> {
}
