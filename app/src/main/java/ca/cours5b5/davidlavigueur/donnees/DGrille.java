package ca.cours5b5.davidlavigueur.donnees;

import java.util.ArrayList;
import java.util.List;

public class DGrille extends Donnees{

    List<DColonne> colonnes = new ArrayList<DColonne>();

    public DGrille(){


    }
    public void ajouterColonne(DColonne colonne){
        colonnes.add(colonne);
    }
    public List<DColonne> getColonnes(){
        return colonnes;
    }

}
