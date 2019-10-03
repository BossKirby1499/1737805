package ca.cours5b5.davidlavigueur.activites;

import android.os.Bundle;

import ca.cours5b5.davidlavigueur.R;
import ca.cours5b5.davidlavigueur.donnees.DParametres;
import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.vues.pages.PParametres;

public class AParametres extends ActiviteAvecDonnees<DParametres, PParametres> {


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
    protected DParametres creerDonnees() {
        DParametres parametres = new DParametres();

        return parametres;
    }
}
