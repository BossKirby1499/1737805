package ca.cours5b5.davidlavigueur.modeles;

import android.graphics.Color;

import ca.cours5b5.davidlavigueur.donnees.DCase;
import ca.cours5b5.davidlavigueur.donnees.DGrille;
import ca.cours5b5.davidlavigueur.donnees.DPartie;
import ca.cours5b5.davidlavigueur.enumeration.ECouleur;
import ca.cours5b5.davidlavigueur.enumeration.ETailleGrille;
import ca.cours5b5.davidlavigueur.vues.pages.PPartie;

public class MPartie extends Modele<DPartie, PPartie> {


    public MPartie(DPartie donnees, PPartie page) {
        super(donnees, page);
    }
    public void setColorSuivant(ECouleur color){

        donnees.setColorSuivant(color);
    }
    public void setTailleGrille(ETailleGrille grilleTaille){

        donnees.setTailleGrille(grilleTaille);
    }
    public void setGrille(DGrille grille){

        donnees.setGrille(grille);
    }


    public void jouerIci(int colonne){
        DCase cases = new DCase();
        if(donnees.getColorSuivant() == ECouleur.rouge) {

            cases.setColor(ECouleur.rouge);
            donnees.setColorSuivant(ECouleur.jaune);

        }else{


            cases.setColor(ECouleur.jaune);
            donnees.setColorSuivant(ECouleur.rouge);

        }

        donnees.getGrille().getColonnes().get(colonne).ajouterJeton(cases);
        page.rafraichirAffichage(donnees);


    }


}
