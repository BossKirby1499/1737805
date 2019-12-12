package ca.cours5b5.davidlavigueur.activites;


import android.os.Bundle;

import ca.cours5b5.davidlavigueur.global.GLog;

public abstract class ActiviteAvecControles extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        GLog.appel(this);

        super.onCreate(savedInstanceState);

        recupererControles();


    }
    protected abstract void recupererControles();


}
