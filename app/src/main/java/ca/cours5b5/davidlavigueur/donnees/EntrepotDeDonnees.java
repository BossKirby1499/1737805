package ca.cours5b5.davidlavigueur.donnees;

import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class EntrepotDeDonnees {

    static Map< Class<? extends Donnees>, Donnees> classDonneesMap = new HashMap<>();

    public static <D extends Donnees>
        D obtenirDonnees(Class<D> classeDonnees){

        if(siDonneesSontDansEntrepot(classeDonnees)){
            return donneesDansEntrepot(classeDonnees);
        }else{
           D donnees = creerDonnees(classeDonnees);
           entreposerDonnees(donnees);
           return donnees;
        }
    }
    private static<D extends Donnees> D donneesDansEntrepot(Class<? extends Donnees> classeDonnees){

       return (D) classDonneesMap.get(classeDonnees);

    }
    private static boolean siDonneesSontDansEntrepot(Class<? extends Donnees> classeDonnees){

        Boolean bool = classDonneesMap.containsKey(classeDonnees);
        return bool;

    }
    private static<D extends Donnees> D creerDonnees(Class<D> classeDonnees){

        try {

            D donnees = classeDonnees.newInstance();
            return donnees;
        }catch(IllegalAccessException | InstantiationException e){

        }
            return null;
    }
    private static<D extends Donnees> void entreposerDonnees(D donnees){

        classDonneesMap.put(donnees.getClass(),donnees);
    }
}
