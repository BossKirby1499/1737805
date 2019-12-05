package ca.cours5b5.davidlavigueur.commandes;

import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.modeles.MPartie;

public class CCoupIci extends Commande{

    private static MPartie modeleCommande;


    public static void initialiser(MPartie modele){

        modeleCommande = modele;

    }
    private   int colonne;

    public CCoupIci(int colonneJeu){

        colonne = colonneJeu;

    }

    @Override
    public void executer() {
        GLog.appel(this);
        modeleCommande.jouerIci(colonne);
    }
    public boolean siExecutable(){
        GLog.appel(this);
        return modeleCommande.siJouerPossible(colonne);

    }
}
