package ca.cours5b5.davidlavigueur.activites;

import android.os.Bundle;
import android.telecom.GatewayInfo;

import androidx.appcompat.app.AppCompatActivity;

import ca.cours5b5.davidlavigueur.global.GLog;

public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        GLog.appel(this);
        GLog.valeurs(savedInstanceState);

        int contentViewId = getLayoutId();

        super.setContentView(contentViewId);

    }
    @Override
    protected void onPause(){
        super.onPause();
        GLog.appel(this);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        GLog.appel(this);
    }
    @Override
    protected void onResume(){
        super.onResume();
        GLog.appel(this);
    }


    protected abstract int getLayoutId();


}
