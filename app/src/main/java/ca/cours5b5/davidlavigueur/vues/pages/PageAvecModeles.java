package ca.cours5b5.davidlavigueur.vues.pages;

import android.content.Context;
import android.util.AttributeSet;

import java.io.IOException;

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
}
