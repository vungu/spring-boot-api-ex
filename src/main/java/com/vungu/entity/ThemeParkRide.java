package com.vungu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity       //Spring boot known about our entities when we annotate with @ annotations
// Lombok annotation ////////////////////////
@Getter      // gets a methods
@ToString   // to string methods
@NoArgsConstructor // no argument methods
///////////////////////////////////////////
public class ThemeParkRide {
    /// Class Member Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Automatically generated an id when we insert a new ride
    private Long id;
    @NotEmpty
    private String name; // ride name
    @NotEmpty
    private String description; //ride description
    private int thrillFactor;
    private int vomitFactor;
    /////////////////////////////////////////////


    // constructor
    public ThemeParkRide(String name, String description, int thrillFactor, int vomitFactor) {
        this.name = name;
        this.description = description;
        this.thrillFactor = thrillFactor;
        this.vomitFactor = vomitFactor;
    }
}