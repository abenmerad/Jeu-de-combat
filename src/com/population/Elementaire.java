package com.population;

public class Elementaire extends EtreVivant {
    public Elementaire(String nom, int niveau, int ptSante, int ptArmure, int ptDestruction) {
        super(nom, niveau, ptSante, ptArmure, ptDestruction);
    }

    @Override
    public void Attaquer(EtreVivant cible) {
        System.out.println(this.nom + " lance une attaque.");
        cible.SubirDegats(this.potentielDeDestruction);
    }
}
