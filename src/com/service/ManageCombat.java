package com.service;

import com.population.EtreVivant;

import java.util.concurrent.TimeUnit;

public class ManageCombat {
    private static ManageCombat manager;
    private ManageAssets manageAssets;
    private int compteurTour;
    private EtreVivant premierCombattant;
    private EtreVivant secondCombattant;

    private ManageCombat() throws InterruptedException {
        this.manageAssets = ManageAssets.Initialisation();
        this.premierCombattant = this.manageAssets.GenererPersonnage();
        this.secondCombattant = this.manageAssets.GenererPersonnage();
        this.compteurTour = 0;

        PresenterLesCombattants();
    }

    static public ManageCombat PreparerCombat() throws InterruptedException {
        if(manager == null) {
            manager = new ManageCombat();
        }
        return manager;
    }

    private void PresenterLesCombattants() throws InterruptedException {
        System.out.println("\t\t\t\t LE COMBAT VA BIENTOT COMMENCER");
        TimeUnit.SECONDS.sleep(3);

        System.out.println("\nGénération en cours du premier combattant...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("\n\n\t\tPREMIER COMBATTANT:" + this.premierCombattant.toString());
        System.out.println("\n\nGénération en cours du second combattant...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("\n\n\t\tSECOND COMBATTANT:" + this.secondCombattant.toString());
    }

    public void LancerCombat() throws InterruptedException {
        System.out.println("\n\n\n\tLE COMBAT DEBUTE DANS:");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("\n\t\t 3");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("\n\t\t 2");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("\n\t\t 1");

        while (this.premierCombattant.EstVivant() && this.secondCombattant.EstVivant()) {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("\n\n# Tour " + (this.compteurTour + 1));
            if ((this.compteurTour % 2) == 0) {
                this.premierCombattant.Attaquer(this.secondCombattant);
            } else {
                this.secondCombattant.Attaquer(this.premierCombattant);
            }
            this.compteurTour++;
        }

        if (this.premierCombattant.EstVivant()) {
            System.out.println("\n\n" + this.premierCombattant.getNom() + " a gagné le combat");
        } else {
            System.out.println("\n\n" + this.secondCombattant.getNom() + " a gagné le combat");
        }
    }
}
