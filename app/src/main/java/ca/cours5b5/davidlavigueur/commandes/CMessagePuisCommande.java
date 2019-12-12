package ca.cours5b5.davidlavigueur.commandes;

import android.view.View;

import ca.cours5b5.davidlavigueur.activites.APartieLocale;
import ca.cours5b5.davidlavigueur.activites.ActiviteAvecModeles;
import ca.cours5b5.davidlavigueur.vues.pages.PPartie;
import ca.cours5b5.davidlavigueur.vues.pages.Page;
import ca.cours5b5.davidlavigueur.vues.pages.PageAvecModeles;

public class CMessagePuisCommande extends Commande{

   private static ActiviteAvecModeles activite;


    public static void initialiser(ActiviteAvecModeles activity){

      activite = activity;
    }
    String message;

    public CMessagePuisCommande(String mess){

        message = mess;

    }
    @Override
    public void executer(){
        activite.page.afficherMessagePuisExecuterCommande(message,activite);
    }

}
