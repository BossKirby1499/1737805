package ca.cours5b5.davidlavigueur.activites;

import android.os.Bundle;

import ca.cours5b5.davidlavigueur.R;
import ca.cours5b5.davidlavigueur.global.GLog;

public class AParametres extends Activite {

    String message;
    boolean orien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_parametres);

        AfficherBonjour();
        AfficherOrientation();

    }



    @Override
    protected int getLayoutId(){
        GLog.appel(this);
        return R.layout.page_parametres;
    }


    protected void AfficherBonjour(){

        GLog.appel(this);
        message =  this.getResources().getString(R.string.msg_valeur);
        GLog.valeurs(message);
    }


    protected void AfficherOrientation(){

        GLog.appel(this);
        orien =  this.getResources().getBoolean(R.bool.est_portrait);
        GLog.valeurs("Est-ce qu'on est en portrait?, " + orien);
    }

}
