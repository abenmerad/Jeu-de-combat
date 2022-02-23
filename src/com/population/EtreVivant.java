package com.population;

public abstract class EtreVivant {

    protected String nom;
    protected int niveau;
    protected int pointSante;
    protected int pointArmure;
    protected int potentielDeDestruction;
    protected boolean estVivant;

    public EtreVivant(String nom, int niveau, int ptSante, int ptArmure, int ptDestruction) {
        this.nom = nom;
        this.niveau = niveau;
        this.pointSante = ptSante;
        this.pointArmure = ptArmure;
        this.potentielDeDestruction = ptDestruction;
        this.estVivant = true;
    }

    public String getNom() { return this.nom; }
    public int getPointSante() {
        return this.pointSante;
    }
    public int getPointArmure() {
        return this.pointArmure;
    }
    public boolean EstVivant() { return this.estVivant; }

    public void setPointSante(int sante) { this.pointSante += sante; }
    public void setPotentielDeDestruction(int degats) { this.potentielDeDestruction += degats; }


    public void SubirDegats(int degats) {
        int armureRestante = this.pointArmure - degats;
        int vieRestante = this.pointSante + Math.min(armureRestante, 0);

        if (vieRestante >= 0) {
            this.pointArmure = Math.max(armureRestante, 0);
            this.pointSante = Math.max(vieRestante, 0);

            System.out.println(this.nom + " subit " + degats + " points de dégats" +
                    "\n\n\t" + this.nom +
                    " - Armure restante: " + this.pointArmure +
                    "\n\t" + this.nom +
                    " - Santé restante: " + this.pointSante + "\n");
        } else {
            this.Mourir();
        }
    }

    private void Mourir() {
        this.estVivant = false;
        System.out.println(this.nom + " a été tué.");
    }

    public void Attaquer(EtreVivant cible) {
        if(!cible.EstVivant()) {
            System.out.println(this.nom + " attaque le cadavre de " + cible.getNom());
        }
    }

    @Override
    public String toString() {
        String texte = "\nNom: " + this.nom
                     + "\nNiveau: " + this.niveau
                     + "\nSanté: " + this.pointSante
                     + "\nArmure: " + this.pointArmure
                     + "\nDegats potentiels: " + this.potentielDeDestruction + " PV / attaque";
        return texte;
    }
}
