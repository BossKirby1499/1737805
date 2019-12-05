package ca.cours5b5.davidlavigueur.commandes;


import ca.cours5b5.davidlavigueur.enumeration.ETailleGrille;
import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.modeles.MParametres;
import ca.cours5b5.davidlavigueur.modeles.Modele;

public class CTailleGrille extends Commande {

    private static MParametres modeleCommande;

    public static void initialiser(MParametres modele){

        modeleCommande = modele;

    }
    private ETailleGrille tailleGrille;
    public CTailleGrille(ETailleGrille eTailleGrille) {
        tailleGrille = eTailleGrille;
    }
    @Override
    public void executer() {
        GLog.appel(this);
        modeleCommande.changerTailleGrille(tailleGrille);

    }
    public boolean siExecutable(){
        GLog.appel(this);
       return modeleCommande.siTailleExisteDeja(tailleGrille);

    }
}
