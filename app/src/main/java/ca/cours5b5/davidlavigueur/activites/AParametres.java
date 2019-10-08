package ca.cours5b5.davidlavigueur.activites;

import ca.cours5b5.davidlavigueur.R;
import ca.cours5b5.davidlavigueur.donnees.DParametres;
import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.modeles.MParametres;
import ca.cours5b5.davidlavigueur.modeles.Modele;
import ca.cours5b5.davidlavigueur.vues.pages.PParametres;

public class AParametres extends ActiviteAvecModeles<DParametres, MParametres, PParametres> {


    @Override
    protected int getLayoutId(){
        GLog.appel(this);
        return R.layout.page_parametres;
    }


    @Override
    protected int getIdPage() {
        return R.id.param;
    }

    @Override
    protected Class<DParametres> getClassDonnees() {
        Class classeDParametres = DParametres.class;
       return classeDParametres;
    }

    @Override
    protected void creerModele(DParametres donnees, PParametres page) {
            Modele modele =  new MParametres(donnees,page);


    }
}
