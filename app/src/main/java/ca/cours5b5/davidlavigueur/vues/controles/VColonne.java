package ca.cours5b5.davidlavigueur.vues.controles;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.davidlavigueur.donnees.DCase;
import ca.cours5b5.davidlavigueur.enumeration.ECouleur;
import ca.cours5b5.davidlavigueur.global.GLog;

public class VColonne extends LinearLayout {

    public VEntete entete;
    public ArrayList<VCase>  cases =  new ArrayList<VCase>();

    public VColonne(Context context) {
        super(context);
    }

    public VColonne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VColonne(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VColonne(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public VColonne(Context context, int hauteur, int largeur) {
        super(context);
        GLog.appel(this);
        remplirColonne(largeur,hauteur);
    }


    public void remplirColonne(int largeur, int hauteur){

        LayoutParams layoutparams = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0,2f);
        layoutparams.leftMargin = 10;
        layoutparams.rightMargin = 20;
        this.setOrientation(LinearLayout.VERTICAL);

        entete = new VEntete(this.getContext(),largeur);

        this.addView(entete,layoutparams);
        LayoutParams layoutparamsCase = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0,1f);
        layoutparamsCase.leftMargin = 10;
        layoutparamsCase.rightMargin = 20;

        for(int j= hauteur; j>=0; j--){
            VCase caseTemp = new VCase(this.getContext(),j,largeur);
            cases.add(caseTemp);
            this.addView(caseTemp,layoutparamsCase);
        }

    }

    public void afficherJetons(List<DCase> jetons) {

        for(int i = 0; i < jetons.size() ; i++){
            int caseCouleur = cases.size()-i-1;
            if(caseCouleur >= 0 ) {

                cases.get(caseCouleur).setBackgroundColor(couleurAfficher(jetons.get(i)));
            }

        }



    }
    public int couleurAfficher(DCase dCase) {

        if(dCase.getColor() == ECouleur.rouge){
            return Color.RED;
        }else{
            return Color.YELLOW;
        }
    }
}