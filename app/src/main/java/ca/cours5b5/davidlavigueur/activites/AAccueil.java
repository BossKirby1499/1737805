package ca.cours5b5.davidlavigueur.activites;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import ca.cours5b5.davidlavigueur.R;
import ca.cours5b5.davidlavigueur.global.GLog;

public class AAccueil extends ActiviteAvecControles {


  Button deconnexion;
  Button jouer;
  Button jouerEnLigne;
  Button parametres;

    @Override
    protected int getLayoutId(){
        GLog.appel(this);
        return R.layout.page_accueil;
    }

    @Override
    protected void recupererControles() {
        GLog.appel(this);

        deconnexion = this.findViewById(R.id.deconnexion);
        jouer = this.findViewById(R.id.jouer);
        jouerEnLigne = this.findViewById(R.id.jouerEnLigne);
        parametres = this.findViewById(R.id.parametres);

        GLog.valeurs(deconnexion, jouer, jouerEnLigne, parametres);

        jouer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                demarrerPartie();

            }
        });
        parametres.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                pageParametres();

            }
        });

    }

    public void demarrerPartie(){

        Intent intention = new Intent(this, APartieLocale.class);
        this.startActivity(intention);
    }
    public void pageParametres(){

        Intent intention = new Intent(this, AParametres.class);
        this.startActivity(intention);
    }
}
