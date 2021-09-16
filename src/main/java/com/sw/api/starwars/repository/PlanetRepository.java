package com.sw.api.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sw.api.starwars.entity.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, String>{

}
