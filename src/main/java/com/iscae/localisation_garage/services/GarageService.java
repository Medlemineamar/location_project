package com.iscae.localisation_garage.services;

import com.iscae.localisation_garage.entities.Garage;
import com.iscae.localisation_garage.repositories.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageService {

    GarageRepository garageRepository;

    @Autowired
    public GarageService(GarageRepository garageRepository){
        this.garageRepository = garageRepository;

    }



    public Garage getOne(Long id){
        return garageRepository.getReferenceById(id);
    }

    public List<Garage> list(){
        return garageRepository.findAll();
    }

    public void delete(Long id){
        garageRepository.deleteById(id);
    }

   public void saveOne(Garage garage){
        garageRepository.save(garage);
    }

    public void update(Garage newGarage , Long id){
       Optional<Garage> optionalGarage =  garageRepository.findById(id);
       Garage oldGarage = optionalGarage.get();




        oldGarage.setNom(newGarage.getNom());
        oldGarage.setNomDuResponsable(newGarage.getNomDuResponsable());
        oldGarage.setNumeroTelephone(newGarage.getNumeroTelephone());


        oldGarage.setMecanicienDisponible(newGarage.isMecanicienDisponible());
        oldGarage.setElectricienDisponible(newGarage.isElectricienDisponible());
        oldGarage.setTolierDisponible(newGarage.isTolierDisponible());
        oldGarage.setServiceDepannage(newGarage.isServiceDepannage());
        oldGarage.setAdresse(newGarage.getAdresse());
        oldGarage.setLatitude(newGarage.getLatitude());
        oldGarage.setLongitude(newGarage.getLongitude());

        oldGarage.setMoughataa(newGarage.getMoughataa());





        garageRepository.saveAndFlush(oldGarage);
    }
}
