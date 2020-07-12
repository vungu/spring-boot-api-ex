package com.vungu.repository;

import com.vungu.entity.ThemeParkRide;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// when define a repository you don't have to implement it because it add all the code automatically
@Repository // Class annotated with repository so that spring boot know what type of class it is
public interface ThemeParkRideRepository extends CrudRepository<ThemeParkRide, Long> {
    List<ThemeParkRide> findByName(String name);// Take in a sting(Ride name) and return a list of theme park ride
}