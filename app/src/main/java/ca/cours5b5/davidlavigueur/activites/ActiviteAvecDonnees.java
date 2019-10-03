package ca.cours5b5.davidlavigueur.activites;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.LinearLayout;

import ca.cours5b5.davidlavigueur.donnees.Donnees;
import ca.cours5b5.davidlavigueur.vues.pages.Page;
import ca.cours5b5.davidlavigueur.vues.pages.PageAvecDonnees;

public abstract class ActiviteAvecDonnees<D extends Donnees,P extends PageAvecDonnees>
                                                    extends Activite{

    private D donnees;
    private P page;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        initialiserDonneesPage();
    }

    private void initialiserDonneesPage(){
        donnees = creerDonnees();
        initialiserPage(donnees);


    }
    private void initialiserPage(D donnees){
        page = recupererPage();
        page.creerAffichage(donnees);

    }
    private P recupererPage(){

    int id  = getIdPage();
    return findViewById(id);

    }
    @Override
    protected void onResume(){
        super.onResume();
        page.rafraichirAffichage(donnees);


    }
    protected abstract int getIdPage();
    protected abstract D creerDonnees();


}
