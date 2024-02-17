package com.iscae.localisation_garage.controllers;



import com.iscae.localisation_garage.entities.Garage;
import com.iscae.localisation_garage.repositories.GarageRepository;
import com.iscae.localisation_garage.services.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GarageController {

    @Autowired
    private GarageService garageService;

    @GetMapping("/")
    public String home(Model model) {
        List<Garage> garages = garageService.list();
        model.addAttribute("garages", garages);
        return "garage";
            }

    @GetMapping("/garage/add")
    public String showAddForm(Model model) {

        model.addAttribute("garage", new Garage());
        return "add-garage";
    }


    @GetMapping("/garage/update/{id}")
    public String update(Model model, @PathVariable Long id) {
        Garage garage = garageService.getOne(id);



        model.addAttribute("garage", garage );
        model.addAttribute("idgarage", id );




        return "update-garage";
    }
    @PostMapping("/garage/update/{id}")
    public String updateGarage(@ModelAttribute Garage garage, @PathVariable Long id ) {
        garageService.update(garage ,id);
        return "redirect:/"; // Redirige vers la page d'accueil après l'ajout
    }
    @PostMapping("/garage/add")
    public String addGarage(@ModelAttribute Garage garage) {
        garageService.saveOne(garage);
        return "redirect:/"; // Redirige vers la page d'accueil après l'ajout
        }
    @PostMapping("/garage/delete/{id}")
    public String delete(@PathVariable Long id){
        garageService.delete(id);
        return "redirect:/";
    }


}