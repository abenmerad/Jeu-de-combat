package com.service;

import com.items.armes.Arme;
import com.items.consommables.Consommable;
import com.items.equipements.*;
import com.items.inventaire.Inventaire;
import com.population.EtreVivant;
import com.population.Humain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManageAssets {
    private static ManageAssets manager;
    private List<Arme> lesArmes;
    private List<Consommable> lesConsommables;
    private List<Armure> lesArmures;
    private List<Inventaire> lesInventaires;
    private List<EtreVivant> lesPersonnages;
    private AssetLoader assetLoader;

    private ManageAssets() {
        this.assetLoader = new AssetLoader();

        this.lesArmes = this.assetLoader.ChargerArme();
        this.lesConsommables = this.assetLoader.ChargerConsommable();
        this.lesInventaires = this.assetLoader.ChargerInventaire();
        this.lesPersonnages = this.assetLoader.ChargerPopulation();
        this.lesArmures = this.assetLoader.ChargerEquipement();
    }

    public static ManageAssets Initialisation() {
        if (manager == null) {
            manager = new ManageAssets();
        }
        return manager;
    }

    public List<Arme> lesArmes() {
        return lesArmes;
    }

    public void setLesArmes(List<Arme> lesArmes) {
        this.lesArmes = lesArmes;
    }

    public List<Consommable> lesConsommables() {
        return lesConsommables;
    }

    public List<Tete> getLesTetes() {
        List<Tete> lesTetes = new ArrayList<>();

        for (Armure armure : this.lesArmures) {
            if (armure instanceof Tete ) {
                lesTetes.add((Tete) armure);
            }
        }
        return lesTetes;
    }

    public List<Buste> getLesBustes() {
        List<Buste> lesBustes = new ArrayList<>();

        for (Armure armure : this.lesArmures) {
            if (armure instanceof Buste) {
                lesBustes.add((Buste) armure);
            }
        }
        return lesBustes;
    }

    public List<Jambe> getLesJambes() {
        List<Jambe> lesJambes = new ArrayList<>();

        for (Armure armure : this.lesArmures) {
            if (armure instanceof Jambe) {
                lesJambes.add((Jambe) armure);
            }
        }
        return lesJambes;
    }

    public List<Pied> getLesPieds() {
        List<Pied> lesPieds = new ArrayList<>();

        for (Armure armure : this.lesArmures) {
            if (armure instanceof Pied) {
                lesPieds.add((Pied) armure);
            }
        }
        return lesPieds;
    }


    public EtreVivant GenererPersonnage() {
        Random randPersonnage = new Random();
        Random randWeapon = new Random();
        EtreVivant personnage = this.lesPersonnages.get(randPersonnage.nextInt(this.lesPersonnages.size()));

        if(personnage instanceof Humain) {
            ((Humain) personnage).EquiperArme(this.lesArmes.get(randWeapon.nextInt(this.lesArmes.size())));
            GenererArmure(((Humain) personnage));
            GenererInventaire(((Humain) personnage));
            GenerateConsommables(((Humain) personnage));
        }
        return personnage;
    }

    private void GenererInventaire(Humain humain) {
        Random randVie = new Random();
        Random randDegats = new Random();
        Random randInventaire = new Random();
        Inventaire inventaire = this.lesInventaires.get(randInventaire.nextInt(this.lesInventaires.size()));
        humain.setInventaire(inventaire);
    }

    private void GenerateConsommables(Humain humain) {

        while(humain.getInventaire().getCapacite() > 0 ) {
            Random randConsommable = new Random();
            humain.EquiperConsommable(this.lesConsommables.get(randConsommable.nextInt(this.lesConsommables.size())));
        }
    }
    private void GenererArmure(Humain humain) {
        Random randTete = new Random();
        Random randBuste = new Random();
        Random randJambe = new Random();
        Random randPied = new Random();

        Tete tete = getLesTetes().get(randTete.nextInt(getLesTetes().size()));
        Buste buste = getLesBustes().get(randBuste.nextInt(getLesBustes().size()));
        Jambe jambe = getLesJambes().get(randJambe.nextInt(getLesJambes().size()));
        Pied pied = getLesPieds().get(randPied.nextInt(getLesPieds().size()));

        humain.EquiperArmure(tete);
        humain.EquiperArmure(buste);
        humain.EquiperArmure(jambe);
        humain.EquiperArmure(pied);
    }
}
