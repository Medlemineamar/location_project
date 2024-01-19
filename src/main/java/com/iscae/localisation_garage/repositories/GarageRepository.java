package com.iscae.localisation_garage.repositories;

import com.iscae.localisation_garage.entities.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarageRepository extends JpaRepository<Garage, Long> {

}