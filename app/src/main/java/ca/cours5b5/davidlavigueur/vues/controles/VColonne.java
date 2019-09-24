package ca.cours5b5.davidlavigueur.vues.controles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import ca.cours5b5.davidlavigueur.global.GLog;

public class VColonne extends LinearLayout {

    VEntete entete;
    ArrayList<VCase>  cases =  new ArrayList<VCase>();

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

        for(int j= 0; j<= hauteur; j++){
            VCase caseTemp = new VCase(this.getContext(),j,largeur);
            cases.add(caseTemp);
            this.addView(caseTemp,layoutparamsCase);
        }

    }
}