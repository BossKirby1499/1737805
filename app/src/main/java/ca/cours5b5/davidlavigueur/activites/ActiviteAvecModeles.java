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
import ca.cours5b5.davidlavigueur.modeles.Modele;
import ca.cours5b5.davidlavigueur.vues.pages.PageAvecModeles;

public abstract class ActiviteAvecModeles<D extends Donnees,M extends Modele,
        P extends PageAvecModeles> extends Activite {


    private D donnees;
    private P page;
    private M modele;
    private Bundle etat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        initialiserDonneesPageModele(savedInstanceState);
    }


    private void initialiserDonneesPageModele(Bundle etat) {

        donnees = recupererDonnees(etat);

        initialiserPageModele(donnees);


    }

    private void initialiserPageModele(D donnees) {
        page = recupererPage();
        page.creerAffichage(donnees);
        modele = creerModele( donnees, page);

    }

    private P recupererPage() {

        int id = getIdPage();
        return findViewById(id);

    }

    @Override
    protected void onPause() {
        super.onPause();
        page.rafraichirAffichage(donnees);
       /* Path chemin = Paths.get(repertoireDonnees().getAbsolutePath(),);

        BufferedWriter buf;
        try {
            buf = Files.newBufferedWriter(chemin, Charset.defaultCharset(), StandardOpenOption.APPEND);
            buf.write(donnees.toString());
            buf.close();

        }catch(Exception e) {
            e.getMessage();
        } Pour entrepot de données*/
       EntrepotDeDonnees.sauvegarderSurDisque(donnees,repertoireDonnees());

    }

    private D recupererDonnees(Bundle etat) {

        Class <D> classeDonnees = getClassDonnees();
        donnees =  EntrepotDeDonnees.obtenirDonnees(classeDonnees, etat);

        return donnees;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        EntrepotDeDonnees.sauvegarderDonnees(donnees, outState);

    }

    private File repertoireDonnees(){
        File repertoireDonnees = this.getFilesDir();
        return repertoireDonnees;
    }


    protected abstract int getIdPage();
    protected abstract Class<D> getClassDonnees();
    protected abstract M creerModele(D donnees, P page);

}
