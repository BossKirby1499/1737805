package ca.cours5b5.davidlavigueur.activites;

import android.os.Bundle;

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
        creerModele( donnees, page);

    }

    private P recupererPage() {

        int id = getIdPage();
        return findViewById(id);

    }

    @Override
    protected void onResume() {
        super.onResume();
        page.rafraichirAffichage(donnees);


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


    protected abstract int getIdPage();
    protected abstract Class<D> getClassDonnees();
    protected abstract void creerModele(D donnees, P page);

}
