package ca.cours5b5.davidlavigueur.donnees;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import ca.cours5b5.davidlavigueur.enumeration.ECouleur;

public class DCase extends Donnees {
    ECouleur color = ECouleur.jaune;
    public DCase() {

    }

    public void setColor(ECouleur color) {
        this.color = color;
    }

    public ECouleur getColor() {


        return color;
    }

}
