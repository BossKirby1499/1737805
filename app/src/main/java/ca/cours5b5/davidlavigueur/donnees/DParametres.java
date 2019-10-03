package ca.cours5b5.davidlavigueur.donnees;

import ca.cours5b5.davidlavigueur.enumeration.ETailleGrille;
import ca.cours5b5.davidlavigueur.global.GConstantes;

public class DParametres extends Donnees {

    ETailleGrille tailleGrille = GConstantes.tailleGrille;
    boolean continuer = GConstantes.continuer;

    public DParametres() {

    }

    public ETailleGrille getTailleGrille() {
        return tailleGrille;
    }

    public boolean getABoolean() {
        return continuer;
    }

    public void setTailleGrille(ETailleGrille taille) {
        tailleGrille = taille;
    }
    public void setContinuer(boolean continuer) {
        this.continuer = continuer;
    }
}