package com.vungu.controller;

import com.vungu.repository.ThemeParkRideRepository;
import com.vungu.entity.ThemeParkRide;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController //Let spring boot know what type of class this is
public class ThemeParkRideController {
    private final ThemeParkRideRepository themeParkRideRepository; // To interact with our repository

    public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {
        this.themeParkRideRepository = themeParkRideRepository;
    }

    @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE) //get a request /ride and produce a json
    public Iterable<ThemeParkRide> getRides() {
        return themeParkRideRepository.findAll();
    }

    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE) // Get request in the path of /ride/{place holder for id)}
    public ThemeParkRide getRide(@PathVariable long id) {      // that can be use in the method parameters with a method parameter with a path variable long id
        return themeParkRideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
        //Throw a exception not found with invalid ride id
    }

    //use the post mapping to /ride. this one will consume a json to produce a json
    @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide themeParkRide) {
        return themeParkRideRepository.save(themeParkRide);
    }
}