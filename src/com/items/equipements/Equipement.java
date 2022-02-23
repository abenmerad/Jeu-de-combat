package com.items.equipements;

import com.game.Main;
import com.items.armes.Arme;
import com.items.armes.ArmeRapproche;

import java.util.ArrayList;
import java.util.List;

public class Equipement {

    protected Tete tete;
    protected Buste buste;
    protected Jambe jambe;
    protected Pied pied;
    protected List<Armure> lesArmures;
    private Arme arme;

    public Equipement() {
        this.tete = null;
        this.buste = null;
        this.jambe = null;
        this.pied = null;

        this.arme = null;

        this.lesArmures = new ArrayList<>();
    }

    public Arme getArme() {
        return this.arme;
    }

    public List<Armure> getLesArmures() {
        return this.lesArmures;
    }

    public void AjouterArme(Arme arme) {
        this.arme = arme;
    }

    public void AjouterArmure(Armure armure) {
        if (armure instanceof Tete) {
            this.tete = (Tete) armure;
        } else if (armure instanceof Buste) {
            this.buste = (Buste) armure;
        } else if (armure instanceof Jambe) {
            this.jambe = (Jambe) armure;
        } else if (armure instanceof Pied) {
            this.pied = (Pied) armure;
        }
        this.lesArmures.add(armure);
    }

    @Override
    public String toString() {
        String texte = "\n\tArmure:";
        for (Armure armure : this.lesArmures) {
            texte += armure.toString();
        }
        texte += this.arme.toString();
        return texte;
    }
}
