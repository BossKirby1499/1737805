package ca.cours5b5.davidlavigueur.activites;

import android.os.Bundle;

import ca.cours5b5.davidlavigueur.global.GLog;

public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        GLog.appel(this);

        super.onCreate(savedInstanceState);

        int contentViewId = getLayoutId();

        super.setContentView(contentViewId);

    }
    protected abstract int getLayoutId();


}
