package com.items.consommables;

import com.items.objets.Objet;
import com.population.EtreVivant;

public abstract class Consommable extends Objet {
    protected enum TypeConsommable {
        Vie, Degats
    }
    protected TypeConsommable typeConsommable;

    public Consommable(String nom, float poids) {
        super(nom, poids);
    }

    public abstract void Consommer(EtreVivant cible);

    @Override
    public String toString() {
        String texte = super.toString();
        texte += "\t\t - Type: " + this.typeConsommable.toString();
        return texte;
    }
}
