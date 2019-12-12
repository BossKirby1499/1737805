package ca.cours5b5.davidlavigueur.commandes;

import ca.cours5b5.davidlavigueur.activites.ActiviteAvecModeles;

public class CQuitterActivite extends Commande{

    private static ActiviteAvecModeles activite;

    public static void initialiser(ActiviteAvecModeles activity){

        activite = activity;
    }
    public CQuitterActivite(){

    }

    @Override
    public  void executer() {
        activite.quitterActivite();
    }
}
