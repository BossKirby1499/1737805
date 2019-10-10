package ca.cours5b5.davidlavigueur.modeles;

import ca.cours5b5.davidlavigueur.donnees.Donnees;
import ca.cours5b5.davidlavigueur.vues.pages.PageAvecModeles;

public abstract class Modele <D extends Donnees,P extends PageAvecModeles> {

    protected D donnees;
    protected P page;

    public Modele(D donnees, P page){

        this.donnees = donnees;
        this.page = page;
        page.installerCapteurs(this);

    }


}
