package com.example.storedprocedure.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
public class Customer {
    @Id
    private Long id;
    private String name;
    private String address;

}
