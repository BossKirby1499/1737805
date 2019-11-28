package ca.cours5b5.davidlavigueur.commandes;

import ca.cours5b5.davidlavigueur.modeles.MPartie;

public class CCoupIci extends Commande{

    private static MPartie modeleCommande;


    public static void initialiser(MPartie modele){

        modeleCommande = modele;

    }
    private static  int colonne;

    public CCoupIci(int colonneJeu){

        colonne = colonneJeu;

    }

    @Override
    public void executer() {
        modeleCommande.jouerIci(colonne);
    }
    public boolean siExecutable(){

        return modeleCommande.siJouerPossible(colonne);

    }
}
