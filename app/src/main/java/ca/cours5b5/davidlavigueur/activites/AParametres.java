package ca.cours5b5.davidlavigueur.activites;

import android.os.Bundle;

import ca.cours5b5.davidlavigueur.R;
import ca.cours5b5.davidlavigueur.global.GLog;

public class AParametres extends Activite {


    @Override
    protected int getLayoutId(){
        GLog.appel(this);
        return R.layout.page_parametres;
    }


}
