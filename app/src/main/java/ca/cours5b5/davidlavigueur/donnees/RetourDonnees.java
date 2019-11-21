package ca.cours5b5.davidlavigueur.donnees;

public interface RetourDonnees<D extends Donnees> {

    void recevoirDonnees(D donnees);

}
