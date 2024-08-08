package com.demo.ektha.serviceinfo.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PersonDetail {

    @Id
    private int id;
    private String name;
    private  int roll;
}
