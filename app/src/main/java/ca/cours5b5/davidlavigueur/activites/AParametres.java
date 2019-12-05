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
        GLog.appel(this);
        return R.id.param;
    }

    @Override
    protected Class<DParametres> getClassDonnees() {
        GLog.appel(this);
        Class classeDParametres = DParametres.class;
       return classeDParametres;
    }

    @Override
    protected MParametres creerModele() {
        GLog.appel(this);
            MParametres modele =  new MParametres(donnees,page);
            return modele;

    }
}
