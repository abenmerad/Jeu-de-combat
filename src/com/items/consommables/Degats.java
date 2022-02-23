package com.items.consommables;


import com.population.EtreVivant;

public class Degats extends Consommable {
    private int pointDegats;

    public Degats(String nom, float poids, int ptDegats)
    {
        super(nom, poids);
        this.typeConsommable = TypeConsommable.Degats;
        this.pointDegats = ptDegats;
    }

    public void Consommer(EtreVivant cible) {
        System.out.println(cible.getNom() + " consomme " + this.nom + " (" + this.pointDegats + ")");
        cible.setPotentielDeDestruction(this.pointDegats);
    }

    @Override
    public String toString() {
        String texte = super.toString();
        texte += "\t\t - Degats: " + this.pointDegats;

        return texte;
    }
}
