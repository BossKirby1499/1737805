package ca.cours5b5.davidlavigueur.activites;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import ca.cours5b5.davidlavigueur.R;
import ca.cours5b5.davidlavigueur.donnees.DGrille;
import ca.cours5b5.davidlavigueur.donnees.DParametres;
import ca.cours5b5.davidlavigueur.donnees.DPartie;
import ca.cours5b5.davidlavigueur.donnees.DPartieLocale;
import ca.cours5b5.davidlavigueur.donnees.EntrepotDeDonnees;
import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.vues.pages.PPartie;

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
        DParametres dParametres = EntrepotDeDonnees.obtenirDonnees(DParametres.class,null, this.getFilesDir());
        if(!dParametres.getABoolean()){
            DGrille grille = new DGrille();
            DPartie partie  = new DPartieLocale(); /*a changer plus tard */
            partie.setGrille(grille);

            EntrepotDeDonnees.entreposerDonnees(partie);
            EntrepotDeDonnees.sauvegarderSurDisque(partie,this.getFilesDir());
        }



        Intent intention = new Intent(this, APartieLocale.class);
        this.startActivity(intention);
    }
    public void pageParametres(){

        Intent intention = new Intent(this, AParametres.class);
        this.startActivity(intention);
    }

}
