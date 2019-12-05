package ca.cours5b5.davidlavigueur.vues.pages;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.davidlavigueur.donnees.DPartie;
import ca.cours5b5.davidlavigueur.modeles.MPartie;

public class PPartieLocale extends PPartie{

    public PPartieLocale(Context context) {
        super(context);
    }

    public PPartieLocale(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public PPartieLocale(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void installerCapteurs(MPartie modele) {

    }


}
