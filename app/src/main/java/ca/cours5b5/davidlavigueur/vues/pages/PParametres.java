package ca.cours5b5.davidlavigueur.vues.pages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;

import ca.cours5b5.davidlavigueur.R;
import ca.cours5b5.davidlavigueur.commandes.CContinuerPartie;
import ca.cours5b5.davidlavigueur.commandes.CTailleGrille;
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
    CTailleGrille cTailleGrillePetite;
    CTailleGrille cTailleGrilleMoyenne;
    CTailleGrille cTailleGrilleGrande;
    CContinuerPartie cContinuerPartieOui;
    CContinuerPartie cContinuerPartieNon;


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
        GLog.appel(this);
        if(donnees.getTailleGrille() == ETailleGrille.petite){
            check1.setChecked(true);
            check2.setChecked(false);
            check3.setChecked(false);
        }else if(donnees.getTailleGrille() == ETailleGrille.moyenne){
            check1.setChecked(false);
            check2.setChecked(true);
            check3.setChecked(false);
        }else{
            check1.setChecked(false);
            check2.setChecked(false);
            check3.setChecked(true);
        }

        switch1.setChecked(donnees.getABoolean());
    }

    @Override
    public void installerCapteurs(MParametres modele) {

    }

    @Override
    public void installerCapteurs() {
        GLog.appel(this);
        switch1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(continuerPartie()){
                    cContinuerPartieOui.executer();
                }else{
                    cContinuerPartieNon.executer();
                }

            }
        });
        check1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                cTailleGrillePetite.executer();
             /*   if(check1.isChecked()) {
                    check2.setChecked(false);
                    check3.setChecked(false);
                }*/
            }
        });
        check2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                cTailleGrilleMoyenne.executer();
              /*  if(check2.isChecked()) {
                    check1.setChecked(false);
                    check3.setChecked(false);
                }*/
            }
        });
        check3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                cTailleGrilleGrande.executer();
               /* if(check3.isChecked()) {
                    check1.setChecked(false);
                    check2.setChecked(false);
                }*/
            }
        });

    }


    @Override
    public void rafraichirAffichage(DParametres donnees) {
        GLog.appel(this);
        rafraichirCommandes();
        if(donnees.getTailleGrille() == ETailleGrille.petite){
            check1.setChecked(true);
            check2.setChecked(false);
            check3.setChecked(false);
        }else if(donnees.getTailleGrille() == ETailleGrille.moyenne){
            check1.setChecked(false);
            check2.setChecked(true);
            check3.setChecked(false);
        }else{
            check1.setChecked(false);
            check2.setChecked(false);
            check3.setChecked(true);
        }

    }

    @Override
    public void creerCommandes() {
        GLog.appel(this);
         cContinuerPartieOui = new CContinuerPartie(true);
        cContinuerPartieNon = new CContinuerPartie(false);

         cTailleGrillePetite = new CTailleGrille(ETailleGrille.petite);
         cTailleGrilleMoyenne = new CTailleGrille(ETailleGrille.moyenne);
         cTailleGrilleGrande  = new CTailleGrille(ETailleGrille.grande);
    }



    @Override
    public void rafraichirCommandes() {
        GLog.appel(this);
        check1.setClickable(cTailleGrillePetite.siExecutable());
        check2.setClickable(cTailleGrilleMoyenne.siExecutable());
        check3.setClickable(cTailleGrilleGrande.siExecutable());

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

    private boolean continuerPartie(){
        GLog.appel(this);
        return switch1.isChecked();
    }

}
