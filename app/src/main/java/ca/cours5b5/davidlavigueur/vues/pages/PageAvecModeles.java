package ca.cours5b5.davidlavigueur.vues.pages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

import ca.cours5b5.davidlavigueur.activites.ActiviteAvecModeles;
import ca.cours5b5.davidlavigueur.commandes.CQuitterActivite;
import ca.cours5b5.davidlavigueur.donnees.Donnees;
import ca.cours5b5.davidlavigueur.modeles.Modele;

public abstract class PageAvecModeles<D extends Donnees, M extends Modele> extends Page {

    public PageAvecModeles(Context context) {
        super(context);
    }

    public PageAvecModeles(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PageAvecModeles(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public abstract void  creerAffichage(D donnees);
    public abstract void installerCapteurs(M modele);
    public abstract void  rafraichirAffichage(D donnees);
    public abstract void  creerCommandes();
    public abstract void installerCapteurs();
    public abstract void rafraichirCommandes();
    public void afficherMessagePuisExecuterCommande(String message, ActiviteAvecModeles activiteAvecModeles){

        CQuitterActivite.initialiser(activiteAvecModeles);
        View maVue = activiteAvecModeles.page;
        Snackbar fenetreMessage = Snackbar.make(maVue,message,Snackbar.LENGTH_SHORT);
        fenetreMessage.show();
        fenetreMessage.addCallback(new Snackbar.Callback(){

            @Override
            public void onDismissed(Snackbar snackbar,int event){
                final CQuitterActivite activiteQuitter = new CQuitterActivite();
                activiteQuitter.executer();
            }

        });

    }
}
