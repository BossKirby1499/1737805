package ca.cours5b5.davidlavigueur.vues.controles;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatButton;

public class VEntete extends AppCompatButton {

    public VEntete(Context context) {
        super(context);
    }

    public VEntete(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VEntete(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public VEntete(Context context, int largeur){
        super(context);

        Button entete = new Button(this.getContext());

        entete.setText(Integer.toString(largeur));

    }

}
