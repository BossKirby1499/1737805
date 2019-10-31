package ca.cours5b5.davidlavigueur.donnees;

import android.graphics.Color;

import ca.cours5b5.davidlavigueur.enumeration.ECouleur;
import ca.cours5b5.davidlavigueur.enumeration.ETailleGrille;
import ca.cours5b5.davidlavigueur.vues.controles.VGrille;

public abstract class DPartie extends Donnees {
    DGrille grille;
    ECouleur colorSuivant;
    ETailleGrille taille;


    public DPartie(){
        grille = new DGrille();
        taille = ETailleGrille.grande;
        colorSuivant = ECouleur.jaune;

    }

    public void setColorSuivant(ECouleur colorSuivant) {
    this.colorSuivant = colorSuivant;
}
    public void setGrille(DGrille grille){

        this.grille = grille;
    }
    public void setTailleGrille(ETailleGrille taille){

        this.taille = taille;
    }
    public ECouleur getColorSuivant( ) {
        return colorSuivant;
    }
    public DGrille getGrille( ){

        return grille;
    }
    public ETailleGrille getTailleGrille( ){

        return taille;
    }
}

