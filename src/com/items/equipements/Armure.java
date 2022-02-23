package com.items.equipements;

import com.items.objets.Objet;

public abstract class Armure extends Objet {
    protected enum TypeEquipement {
        Tete, Buste, Main, Jambe, Pied
    }
    protected TypeEquipement emplacementEquipement;
    protected int pointArmure;

    public Armure(String nom, float poids, TypeEquipement emplacement, int ptArmure)
    {
        super(nom, poids);
        this.pointArmure = ptArmure;
        this.emplacementEquipement = TypeEquipement.valueOf(emplacement.toString());
    }

    public int getPointArmure() { return this.pointArmure; }

    @Override
    public String toString() {
        String texte = super.toString();
        texte += "\t\t - Point armure: " + this.pointArmure;
        return texte;
    }
}
