package ca.cours5b5.davidlavigueur.vues.pages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;

import ca.cours5b5.davidlavigueur.R;
import ca.cours5b5.davidlavigueur.donnees.DParametres;
import ca.cours5b5.davidlavigueur.enumeration.ETailleGrille;
import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.modeles.MParametres;
import ca.cours5b5.davidlavigueur.modeles.Modele;

public class PParametres extends PageAvecModeles<DParametres, MParametres> {

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
    public void creerAffichage(DParametres donnees) {

        if(donnees.getTailleGrille() == ETailleGrille.petite) {
            check1.setChecked(true);
        }else {
            check1.setChecked(false);
        }

        if(donnees.getTailleGrille() == ETailleGrille.moyenne){
            check2.setChecked(true);
        }else {
            check2.setChecked(false);
        }
        if(donnees.getTailleGrille() == ETailleGrille.grande){
            check3.setChecked(true);
        }else {
            check2.setChecked(false);
        }
        switch1.setChecked(donnees.getABoolean());
    }

    @Override
    public void installerCapteurs( final MParametres modele) {

        switch1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                modele.changerSwitch(switch1.isChecked());
            }
        });
        check1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                modele.changerCheckBox(ETailleGrille.petite);

            }
        });
        check2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                modele.changerCheckBox(ETailleGrille.moyenne);
            }
        });
        check3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                modele.changerCheckBox(ETailleGrille.grande);
            }
        });

    }

    @Override
    public void rafraichirAffichage(DParametres donnees) {
        if(donnees.getTailleGrille() == ETailleGrille.petite) {
            check1.setChecked(true);
        }else {
            check1.setChecked(false);
        }

        if(donnees.getTailleGrille() == ETailleGrille.moyenne){
            check2.setChecked(true);
        }else {
            check2.setChecked(false);
        }
        if(donnees.getTailleGrille() == ETailleGrille.grande){
            check3.setChecked(true);
        }else {
            check3.setChecked(false);
        }
        switch1.setChecked(donnees.getABoolean());
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
