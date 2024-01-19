package com.iscae.localisation_garage.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity // Cette annotation indique qu'il s'agit d'une entité JPA
@Data
public class Garage {

    @Id // Indique que le champ ci-dessous est la clé primaire
    @GeneratedValue(strategy = GenerationType.AUTO) // Génère automatiquement la clé primaire
    private Long id;

    private String nom;
    private String nomDuResponsable;
    private String numeroTelephone;

    private boolean mecanicienDisponible;
    private boolean electricienDisponible;
    private boolean tolierDisponible;
    private boolean serviceDepannage;
    private String adresse;
    private double latitude;
    private double longitude;
    private String moughataa;


}