package ca.cours5b5.davidlavigueur.activites;

import ca.cours5b5.davidlavigueur.R;
import ca.cours5b5.davidlavigueur.donnees.DPartieLocale;
import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.modeles.MPartieLocale;
import ca.cours5b5.davidlavigueur.vues.pages.PPartieLocale;

public class APartieLocale extends  ActiviteAvecModeles<DPartieLocale, MPartieLocale, PPartieLocale>  {


    @Override
    protected int getLayoutId() {
        GLog.appel(this);
        return R.layout.page_partie_locale;
    }
    @Override
    protected int getIdPage() {
        return R.id.partieLocale;
    }

    protected Class<DPartieLocale> getClassDonnees() {
        Class classDPartieLocale = DPartieLocale.class;
        return classDPartieLocale;
    }
    @Override
    protected MPartieLocale creerModele() {
        MPartieLocale modele =  new MPartieLocale(donnees,page);
        return modele;

    }

}
