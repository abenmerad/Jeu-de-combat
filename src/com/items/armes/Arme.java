package com.items.armes;

import com.items.objets.Objet;

public abstract class Arme extends Objet {

    protected int potentielDeDestruction;

    public Arme(String nom, float poids, int potentielDeDestruction){
        super(nom, poids);
        this.potentielDeDestruction = potentielDeDestruction;
    }

    public int getPotentielDeDestruction() {
        return potentielDeDestruction;
    }

    @Override
    public String toString() {
        String texte = "\n\tArme: ";
        texte += super.toString();
        texte += "\t\t - Degats: " + this.potentielDeDestruction;
        return texte;
    }
}
