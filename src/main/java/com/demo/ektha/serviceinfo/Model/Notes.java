package com.demo.ektha.serviceinfo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String tittle;

     private String description;


    public Long getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Notes(String tittle, String description) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
    }

    public Notes(){

    }
}
