package ca.cours5b5.davidlavigueur.vues.pages;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.vues.controles.VGrille;

public abstract class PPartie extends Page {

    VGrille grille;
    public PPartie(Context context) {
        super(context);
    }

    public PPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public PPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void recupererControles(){
        GLog.appel(this);
        int a = (int) (Math.random() * (6 - 2));
        int b = (int) (Math.random() * (6 - 2));
        grille.creerGrille(a,b);
    }
}
