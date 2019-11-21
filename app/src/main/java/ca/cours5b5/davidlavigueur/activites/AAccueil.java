package ca.cours5b5.davidlavigueur.activites;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.davidlavigueur.R;
import ca.cours5b5.davidlavigueur.donnees.DGrille;
import ca.cours5b5.davidlavigueur.donnees.DParametres;
import ca.cours5b5.davidlavigueur.donnees.DPartie;
import ca.cours5b5.davidlavigueur.donnees.DPartieLocale;
import ca.cours5b5.davidlavigueur.donnees.EntrepotDeDonnees;
import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.vues.pages.PPartie;
import ca.cours5b5.davidlavigueur.global.GUsagerCourant;

public class AAccueil extends ActiviteAvecControles {


  Button connexion;
  Button jouer;
  Button jouerEnLigne;
  Button parametres;
    int CODE_LOGIN =122;

    public void effectuerConnexion(){
        GLog.appel(this);
       GLog.valeurs(GUsagerCourant.getId());
        List<AuthUI.IdpConfig> fournisseurDeConnexion = new ArrayList<>();
        fournisseurDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseurDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseurDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());

        Intent intentionConnexion = AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(fournisseurDeConnexion).build();
        this.startActivityForResult(intentionConnexion,CODE_LOGIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent ata){
        GLog.appel(this);
        if(requestCode == CODE_LOGIN){

            if(resultCode == RESULT_OK){
                GLog.valeurs(GUsagerCourant.getId());
                connexion.setText(R.string.deco);
                jouerEnLigne.setEnabled(true);
            }else{

            }
        }
    }
    protected void effectuerDeconnexion(){
        GLog.appel(this);
        GLog.valeurs(GUsagerCourant.getId());
        AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                GLog.valeurs(GUsagerCourant.getId());
                jouerEnLigne.setEnabled(false);
            }
        });

    }
    @Override
    protected int getLayoutId(){
        GLog.appel(this);
        return R.layout.page_accueil;
    }

    @Override
    protected void recupererControles() {
        GLog.appel(this);

        connexion = this.findViewById(R.id.deconnexion);
        jouer = this.findViewById(R.id.jouer);
        jouerEnLigne = this.findViewById(R.id.jouerEnLigne);
        jouerEnLigne.setEnabled(false);
        parametres = this.findViewById(R.id.parametres);

        GLog.valeurs(connexion, jouer, jouerEnLigne, parametres);

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
        connexion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(GUsagerCourant.siConnecte()){

                    effectuerDeconnexion();
                    connexion.setText(R.string.conn);
                }else{
                    effectuerConnexion();

                }

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
