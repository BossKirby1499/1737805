package ca.cours5b5.davidlavigueur.vues.pages;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;

import ca.cours5b5.davidlavigueur.R;
import ca.cours5b5.davidlavigueur.global.GLog;

public class PParametres extends Page {

    TextView texte;
    CheckBox check1;
    CheckBox check2;
    CheckBox check3;
    Switch  switch1;

    public PParametres(Context context) {
        super(context);
    }

    public PParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void recupererControles() {
        GLog.appel(this);
        texte = this.findViewById(R.id.msgTaille);
        check1 = this.findViewById(R.id.checkBox);
        check2 = this.findViewById(R.id.checkBox2);
        check3 = this.findViewById(R.id.checkBox3);
        switch1 = this.findViewById(R.id.switch2);
        GLog.valeurs(texte,check1,check2, check3, switch1);
    }
}
