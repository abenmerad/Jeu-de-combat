package com.items.objets;

public abstract class Objet {
    protected String nom;
    protected float poids;

    protected Objet(String nom, float poids)
    {
        this.nom = nom;
        this.poids = poids;
    }
    public float getPoids() { return this.poids; }
    public String getNom() {
        return this.nom;
    }

    @Override
    public String toString() {
        String texte = "\n\t\t" + this.nom + "\n\t\t - Poids: " + this.poids;
        return texte;
    }
}
