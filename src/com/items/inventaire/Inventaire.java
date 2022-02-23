package com.items.inventaire;

import com.items.equipements.*;
import com.items.objets.Objet;
import com.items.armes.Arme;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
    private String nom;
    private int limitePoids;
    private List<Objet> lesObjets;
    private int capacite;

    public Inventaire(String nom, int limitePoids) {
        this.nom = nom;
        this.limitePoids = limitePoids;
        this.lesObjets = new ArrayList<>();
        this.capacite = 2;
    }

    public List<Objet> getLesObjets() { return this.lesObjets; }
    public String getNom() { return this.nom; }
    public int getLimitePoids() { return this.limitePoids; }
    public float getCapacite() { return this.capacite; }

    public void AjouterObjet(Objet objet) {
        this.lesObjets.add(objet);
        this.capacite--;
    }
    @Override
    public String toString() {
        String texte = "";
        for (Objet objet : this.lesObjets) {
            texte += objet.toString();
        }
        return texte;
    }
}
