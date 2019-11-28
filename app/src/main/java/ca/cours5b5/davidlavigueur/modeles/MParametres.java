package ca.cours5b5.davidlavigueur.modeles;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;

import ca.cours5b5.davidlavigueur.commandes.CContinuerPartie;
import ca.cours5b5.davidlavigueur.commandes.CTailleGrille;
import ca.cours5b5.davidlavigueur.donnees.DParametres;
import ca.cours5b5.davidlavigueur.enumeration.ETailleGrille;
import ca.cours5b5.davidlavigueur.vues.pages.PParametres;

public class MParametres extends Modele<DParametres, PParametres>{


    public MParametres(DParametres donnees, PParametres page) {
        super(donnees, page);
    }

    @Override
    protected void initialiserCommandes() {
        CTailleGrille.initialiser(MParametres.this);
        CContinuerPartie.initialiser(MParametres.this);
    }

    public  void changerTailleGrille(ETailleGrille tailleGrille){

        donnees.setTailleGrille(tailleGrille);
    }
    public  void changerContinuer(Boolean bool){
        donnees.setContinuer(bool);
    }
    public boolean siTailleExisteDeja(ETailleGrille eTailleGrille){

        if(eTailleGrille == donnees.getTailleGrille()){
            return false;
        }else{
            return true;
        }

    }




}
