package ca.cours5b5.davidlavigueur.donnees;

import android.os.Bundle;

import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ca.cours5b5.davidlavigueur.global.GLog;

public class EntrepotDeDonnees {

    static Map< Class<? extends Donnees>, Donnees> classDonneesMap = new HashMap<>();
    private static Gson gson = new GsonBuilder().create();

    public static <D extends Donnees>
        D obtenirDonnees(Class<D> classeDonnees, Bundle etat){


     if(etat != null && siDonneesSontDansEtat(classeDonnees,etat)) {

         return donneesDansEtat(classeDonnees,etat);

     }else{
         if (siDonneesSontDansEntrepot(classeDonnees)) {
             return donneesDansEntrepot(classeDonnees);
         } else {

             D donnees = creerDonnees(classeDonnees);
             entreposerDonnees(donnees);
             return donnees;
         }

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
    public static <D extends Donnees> void sauvegarderDonnees(D donnees, Bundle etat){
        GLog.appel(EntrepotDeDonnees.class);

        String stringDonnee = gson.toJson(donnees);

        etat.putString(clePourClasseDonnees(donnees.getClass()),stringDonnee);
        GLog.valeurs("Données sauvegardées : ", clePourClasseDonnees(donnees.getClass()), stringDonnee);

    }

    private static String clePourClasseDonnees(Class<? extends Donnees>classeDonnee) {
        String classe = classeDonnee.getSimpleName();
        return classe;
    }
    private static boolean siDonneesSontDansEtat(Class<? extends Donnees>classeDonnees,Bundle etat){


      if( etat.getString(clePourClasseDonnees(classeDonnees)) == null){
          return false;

      }else{

          return true;
      }

    }
    private static <D extends Donnees> D donneesDansEtat(Class<D> classeDonnees, Bundle etat){
        GLog.appel(EntrepotDeDonnees.class);


        String donneesJson = "";
        donneesJson = etat.getString(classeDonnees.getSimpleName());



    D donnees = gson.fromJson(donneesJson, classeDonnees);
    GLog.valeurs("Données chargées : ", classeDonnees, donneesJson);
    return donnees;

    }

    public static <D extends Donnees> void sauvegarderSurDisque(D donnees, File repertoireDonnees) {
    }
}
