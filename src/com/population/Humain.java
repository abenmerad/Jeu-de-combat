package com.population;

import com.items.armes.Arme;
import com.items.consommables.Consommable;
import com.items.equipements.Armure;
import com.items.equipements.Equipement;
import com.items.inventaire.Inventaire;

public class Humain extends EtreVivant {
    protected Inventaire inventaire;
    protected Equipement equipement;

    public Humain(String nom, int niveau, int ptSante, int ptArmure, int ptDestruction) {
        super(nom, niveau, ptSante, ptArmure, ptDestruction);
        this.inventaire = null;
        this.equipement = new Equipement();

        this.setArmureDepuisEquipement();
    }

    public Equipement getEquipement() { return this.equipement; }
    public Inventaire getInventaire() { return this.inventaire; }

    public void setInventaire(Inventaire inventaire) {
        this.inventaire = inventaire;
    }

    private void setArmureDepuisEquipement() {
        for (Armure armure : this.equipement.getLesArmures()) {
            this.pointArmure += armure.getPointArmure();
        }
    }

    public void EquiperArmure(Armure armure) {
        this.equipement.AjouterArmure(armure);
    }
    public void EquiperArme(Arme arme) {
        this.equipement.AjouterArme(arme);
    }
    public void EquiperConsommable(Consommable objet) {
        this.inventaire.AjouterObjet(objet);
    }

    @Override
    public void Attaquer(EtreVivant cible) {
        if(cible.EstVivant()) {
            System.out.println(this.nom + " lance une attaque avec " + this.equipement.getArme().getNom());
            cible.SubirDegats(this.equipement.getArme().getPotentielDeDestruction() + this.potentielDeDestruction);
        }
        super.Attaquer(cible);
    }

    @Override
    public String toString() {
        String texte = super.toString();
        texte += "\nEquipement: ";
        texte += this.equipement.toString();
        texte += "\nConsommable: ";
        texte += this.inventaire.toString();

        return texte;
    }
}
