package ca.cours5b5.davidlavigueur.modeles;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;

import ca.cours5b5.davidlavigueur.donnees.DParametres;
import ca.cours5b5.davidlavigueur.enumeration.ETailleGrille;
import ca.cours5b5.davidlavigueur.vues.pages.PParametres;

public class MParametres extends Modele<DParametres, PParametres>{


    public MParametres(DParametres donnees, PParametres page) {
        super(donnees, page);
    }
    public  void changerCheckBox(ETailleGrille tailleGrille){

        donnees.setTailleGrille(tailleGrille);
    }
    public  void changerSwitch(Boolean bool){
        donnees.setContinuer(bool);
    }




}
