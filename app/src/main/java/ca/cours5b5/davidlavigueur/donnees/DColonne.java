package ca.cours5b5.davidlavigueur.donnees;

import java.util.ArrayList;
import java.util.List;

public class DColonne extends Donnees {


   public  List<DCase> jetons = new ArrayList<>();

    public DColonne(){

    }
    public void ajouterJeton(DCase dCase){

        jetons.add(dCase);

    }

    public List<DCase> getJetons(){
        return jetons;
    }


}
