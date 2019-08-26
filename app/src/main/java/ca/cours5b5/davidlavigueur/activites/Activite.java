package ca.cours5b5.davidlavigueur.activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ca.cours5b5.davidlavigueur.global.GLog;

public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        int contentViewId = getContentViewId();

        setContentViewId(contentViewId);

    }
    protected abstract int getContentViewId();
    protected abstract void setContentViewId(int contentViewId);

}
