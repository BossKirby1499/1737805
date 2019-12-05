package ca.cours5b5.davidlavigueur.commandes;

import ca.cours5b5.davidlavigueur.enumeration.ETailleGrille;
import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.modeles.MParametres;

public class CContinuerPartie extends Commande {

    private static MParametres modeleCommande;



    public static void initialiser(MParametres modele){

        modeleCommande = modele;

    }
    private boolean continuer;
    public CContinuerPartie(boolean jeuContinuer){
        GLog.appel(this);
        continuer = jeuContinuer;

    }

    @Override
    public void executer() {
        GLog.appel(this);
        modeleCommande.changerContinuer(continuer);
    }
}
