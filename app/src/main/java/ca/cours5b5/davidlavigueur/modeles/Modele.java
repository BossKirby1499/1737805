package ca.cours5b5.davidlavigueur.modeles;

import ca.cours5b5.davidlavigueur.donnees.Donnees;
import ca.cours5b5.davidlavigueur.vues.pages.PageAvecModeles;

public abstract class Modele <D extends Donnees,P extends PageAvecModeles> {

    public D donnees;
    protected P page;

    public Modele(D donnees, P page){

        this.donnees = donnees;
        this.page = page;

        initialiserCommandes();

    }
    protected abstract void initialiserCommandes();


}
