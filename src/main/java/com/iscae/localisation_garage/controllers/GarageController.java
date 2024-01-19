package com.iscae.localisation_garage.controllers;



import com.iscae.localisation_garage.entities.Garage;
import com.iscae.localisation_garage.repositories.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GarageController {

    @Autowired
    private GarageRepository garageRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Garage> garages = garageRepository.findAll();
        model.addAttribute("garages", garages);
        return "garage";
            }

    @GetMapping("/garage/add")
    public String showAddForm(Model model) {
        model.addAttribute("garage", new Garage());
        return "add-garage";
    }

    @PostMapping("/garage/add")
    public String addGarage(@ModelAttribute Garage garage) {
        garageRepository.save(garage);
        return "redirect:/"; // Redirige vers la page d'accueil après l'ajout
        }


}