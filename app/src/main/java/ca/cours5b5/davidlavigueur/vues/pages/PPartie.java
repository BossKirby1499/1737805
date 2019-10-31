package ca.cours5b5.davidlavigueur.vues.pages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import java.io.IOException;

import ca.cours5b5.davidlavigueur.R;
import ca.cours5b5.davidlavigueur.donnees.DColonne;
import ca.cours5b5.davidlavigueur.donnees.DGrille;
import ca.cours5b5.davidlavigueur.donnees.DParametres;
import ca.cours5b5.davidlavigueur.donnees.DPartie;
import ca.cours5b5.davidlavigueur.donnees.EntrepotDeDonnees;
import ca.cours5b5.davidlavigueur.enumeration.ETailleGrille;
import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.modeles.MPartie;
import ca.cours5b5.davidlavigueur.vues.controles.VColonne;
import ca.cours5b5.davidlavigueur.vues.controles.VGrille;

public abstract class PPartie extends PageAvecModeles<DPartie, MPartie> {

    VGrille grille;
    public PPartie(Context context) {
        super(context);
    }

    public PPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public PPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void recupererControles(){
        GLog.appel(this);

        grille = this.findViewById(R.id.grille);


    }
    public void creerAffichage(DPartie donnees) {

        GLog.appel(this);


       DParametres dParametres = EntrepotDeDonnees.obtenirDonnees(DParametres.class,null,this.getContext().getFilesDir());
       donnees.setTailleGrille(dParametres.getTailleGrille());
       grille.creerGrille(ETailleGrille.getHauteur(donnees.getTailleGrille()),ETailleGrille.getLargeur(donnees.getTailleGrille()));

      for(int i = 0; i <= ETailleGrille.getLargeur(donnees.getTailleGrille()); i++){

           DColonne col = new DColonne();
           donnees.getGrille().ajouterColonne(col);


       }
      rafraichirAffichage(donnees);
    }
    public void installerCapteurs(final MPartie modele){
        GLog.appel(this);

        for( int i = 0; i < grille.tabCol.size();i++){

           VColonne col =  grille.tabCol.get(i);

            final int idCol = i;

            col.entete.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {

                    GLog.appel(this);
                    modele.jouerIci(idCol);

                }

            });
         }

    }
    public void rafraichirAffichage(DPartie donnees){
        grille.afficherJetons(donnees);

    }

}
