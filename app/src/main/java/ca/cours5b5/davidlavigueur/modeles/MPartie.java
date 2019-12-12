package ca.cours5b5.davidlavigueur.modeles;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ca.cours5b5.davidlavigueur.activites.APartieLocale;
import ca.cours5b5.davidlavigueur.activites.ActiviteAvecModeles;
import ca.cours5b5.davidlavigueur.commandes.CContinuerPartie;
import ca.cours5b5.davidlavigueur.commandes.CCoupIci;
import ca.cours5b5.davidlavigueur.commandes.CMessagePuisCommande;
import ca.cours5b5.davidlavigueur.commandes.CQuitterActivite;
import ca.cours5b5.davidlavigueur.donnees.DCase;
import ca.cours5b5.davidlavigueur.donnees.DColonne;
import ca.cours5b5.davidlavigueur.donnees.DGrille;
import ca.cours5b5.davidlavigueur.donnees.DPartie;
import ca.cours5b5.davidlavigueur.enumeration.ECouleur;
import ca.cours5b5.davidlavigueur.enumeration.ETailleGrille;
import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.vues.controles.VCase;
import ca.cours5b5.davidlavigueur.vues.controles.VColonne;
import ca.cours5b5.davidlavigueur.vues.pages.PPartie;

public class MPartie extends Modele<DPartie, PPartie> {


    public MPartie(DPartie donnees, PPartie page) {
        super(donnees, page);
    }

    @Override
    protected void initialiserCommandes() {
        CCoupIci.initialiser(MPartie.this);



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
        GLog.appel(this);
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
        testerSiPartieGagnee();


    }
    public boolean siJouerPossible(int colonne){
        GLog.appel(this);
       List<DColonne> colonnes = donnees.getGrille().getColonnes();
        DColonne col = colonnes.get(colonne);
        if(col.jetons.size() > ETailleGrille.getHauteur(donnees.getTailleGrille())){
            return false;
        }else{
            return true;
        }

    }
    private void reagirPartieGagnee(){
        CMessagePuisCommande.initialiser((APartieLocale) page.getContext());
        CMessagePuisCommande commandeMessage = new CMessagePuisCommande("Les "+getIdMessageAuGagnant()+" gagnent");
        commandeMessage.executer();


    }
    private void testerSiPartieGagnee(){
        if(siPartieGagnee()){
            reagirPartieGagnee();
        }
    }
    private boolean siPartieGagnee(){
        final int random = new Random().nextInt(2);
        GLog.valeurs(random);
        if(random == 1){
            GLog.valeurs("T'a gagné");
            return true;
        }else{
            GLog.valeurs("T'a perdu");
            return false;
        }
    }
    private String getIdMessageAuGagnant(){
        String couleurNom;
        ECouleur color = donnees.getColorSuivant();
        if(color == ECouleur.rouge){
            couleurNom = "jaune";

        }else{
            couleurNom = "rouge";

        }
        return couleurNom;
    }


}
