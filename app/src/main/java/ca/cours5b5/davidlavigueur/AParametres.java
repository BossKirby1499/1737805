package ca.cours5b5.davidlavigueur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ca.cours5b5.davidlavigueur.activites.Activite;
import ca.cours5b5.davidlavigueur.global.GLog;

public class AParametres extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_parametres);
        Hello();
    }
    @Override
    protected int getContentViewId(){
        return R.layout.page_parametres;
    }
    @Override
    protected void setContentViewId(int contentViewId){

    }
    protected void Hello(){

        GLog.appel(this);
        GLog.valeurs("Bonjour");

    }

}
