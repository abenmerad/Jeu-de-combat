package com.items.consommables;

import com.population.EtreVivant;

public class Vie extends Consommable {
    private int pointVie;

    public Vie(String nom, float poids, int ptVie)
    {
        super(nom, poids);
        this.typeConsommable = TypeConsommable.Vie;
        this.pointVie = ptVie;
    }

    public void Consommer(EtreVivant cible) {
        System.out.println(cible.getNom() + " consomme " + this.nom + " (" + this.pointVie + "PV)");
        cible.setPotentielDeDestruction(this.pointVie);
    }

    @Override
    public String toString() {
        String texte = super.toString();
        texte += "\t\t - Vie: " + this.pointVie;

        return texte;
    }
}
