package ca.cours5b5.davidlavigueur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Locale;

import ca.cours5b5.davidlavigueur.activites.Activite;
import ca.cours5b5.davidlavigueur.global.GLog;

public class AParametres extends Activite {

    String message;
    boolean orien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_parametres);

        Bonjour();
        Orientation();

    }
    @Override
    protected int getContentViewId(){
        return R.layout.page_parametres;
    }
    @Override
    protected void setContentViewId(int contentViewId){

    }
    protected void Bonjour(){

        GLog.appel(this);
        message =  this.getResources().getString(R.string.msg_valeur);
        GLog.valeurs(message);
    }
    protected void Orientation(){

        GLog.appel(this);
        orien =  this.getResources().getBoolean(R.bool.est_portrait);
        GLog.valeurs("Est-ce qu'on est en portrait?, " + orien);
    }


}
