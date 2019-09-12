package ca.cours5b5.davidlavigueur.vues.pages;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.davidlavigueur.global.GLog;

public abstract class PPartie extends Page {



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
    }
}
