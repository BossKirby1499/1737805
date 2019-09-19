package ca.cours5b5.davidlavigueur.vues.controles;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatButton;

public class VCase extends AppCompatButton {


    public VCase(Context context) {
        super(context);
    }

    public VCase(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VCase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VCase(Context context,int hauteur, int largeur) {
        super(context);
        Button caseJeu = new Button(this.getContext());
        caseJeu.setText(Integer.toString(largeur)+" , "+Integer.toString(hauteur));
    }


}

