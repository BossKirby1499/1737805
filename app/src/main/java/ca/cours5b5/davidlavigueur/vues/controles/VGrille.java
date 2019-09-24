package ca.cours5b5.davidlavigueur.vues.controles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import ca.cours5b5.davidlavigueur.global.GLog;

public class VGrille extends LinearLayout {

    ArrayList<VColonne>  tabCol =  new ArrayList<VColonne>();

    public VGrille(Context context) {
        super(context);
    }

    public VGrille(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VGrille(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    public void creerGrille(int hauteur, int largeur){
        GLog.appel(this);

        LayoutParams layoutparams = new LayoutParams(
                0,ViewGroup.LayoutParams.MATCH_PARENT,3f);
        layoutparams.leftMargin = 10;
        layoutparams.rightMargin = 20;


      for(int i= 0; i<= largeur; i++){
            VColonne colTemp = new VColonne(this.getContext(),hauteur,i);
            tabCol.add(colTemp);
            this.addView(colTemp,layoutparams);

      }






    }
}
