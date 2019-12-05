package ca.cours5b5.davidlavigueur.activites;

import android.os.Bundle;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import ca.cours5b5.davidlavigueur.donnees.Donnees;
import ca.cours5b5.davidlavigueur.donnees.EntrepotDeDonnees;
import ca.cours5b5.davidlavigueur.donnees.RetourDonnees;
import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.modeles.Modele;
import ca.cours5b5.davidlavigueur.vues.pages.PageAvecModeles;

import static ca.cours5b5.davidlavigueur.donnees.EntrepotDeDonnees.obtenirDonnees;
import static ca.cours5b5.davidlavigueur.donnees.EntrepotDeDonnees.sauvegarderDonneesSurServeur;

public abstract class ActiviteAvecModeles<D extends Donnees,M extends Modele,
        P extends PageAvecModeles> extends Activite {


    protected D donnees;
    protected P page;
    private M modele;
    private Bundle etat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GLog.appel(this);
        super.onCreate(savedInstanceState);
        page = recupererPage();
        obtenirDonneesPuisInitialiserModelePage();
    }



    private P recupererPage() {
        GLog.appel(this);
        int id = getIdPage();
        return findViewById(id);

    }

    @Override
    protected void onPause() {
        GLog.appel(this);
        super.onPause();
        sauvegarderDonneesSurServeur(donnees);


    }
    /*private File repertoireDonnees(){
        File repertoireDonnees = this.getFilesDir();
        return repertoireDonnees;
    }*/
    private void creerAffichage(){
        GLog.appel(this);
        page.creerAffichage(donnees);
        page.creerCommandes();
        page.installerCapteurs();
    }
    private void rafraichirAffichage(){
        GLog.appel(this);
        page.rafraichirAffichage(donnees);
        page.rafraichirCommandes();
    }
    private void initialiserPage(){
        GLog.appel(this);
        creerAffichage();
        rafraichirAffichage();

    }
    private void memoriserDonneesPuisInitialiserModelePage(D donneesObtenues){
        GLog.appel(this);
        donnees = donneesObtenues;
        modele = creerModele();
        initialiserPage();


    }
    private void obtenirDonneesPuisInitialiserModelePage(){
        GLog.appel(this);
        RetourDonnees retourDonnees = new RetourDonnees() {
            @Override
            public void recevoirDonnees(Donnees donnees) {

                memoriserDonneesPuisInitialiserModelePage((D) donnees);
            }
        };
        obtenirDonnees(getClassDonnees(), retourDonnees);


    }

    protected abstract int getIdPage();
    protected abstract Class<D> getClassDonnees();
    protected abstract M creerModele();

    /*private D recupererDonnees(Bundle etat) {

        Class <D> classeDonnees = getClassDonnees();

            donnees =  EntrepotDeDonnees.obtenirDonnees(classeDonnees, etat,repertoireDonnees());


        return donnees;
    }*/

   /* @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        EntrepotDeDonnees.sauvegarderDonnees(donnees, outState);

    }*/
        /*private void initialiserPageModele(D donnees) {
        page = recupererPage();

            page.creerAffichage(donnees);



        modele = creerModele( donnees, page);

    }*/
        /*private void initialiserDonneesPageModele(Bundle etat) {

        donnees = recupererDonnees(etat);

        initialiserPageModele(donnees);


    }*/



}
