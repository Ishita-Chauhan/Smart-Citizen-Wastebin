package com.pdeu.hackathon.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collation = "citizens")
public class Citizen {

    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;

}
