package com.items.armes;

public class ArmeADistance extends Arme{
    private float tauxDePrecision;

    public ArmeADistance(String nom, float poids, int potentielDeDestruction, float tauxPrecision)
    {
        super(nom, poids, potentielDeDestruction);
        this.tauxDePrecision = tauxPrecision;
    }
}
