package ca.cours5b5.davidlavigueur.donnees;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.MappedByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ca.cours5b5.davidlavigueur.global.GLog;

public class EntrepotDeDonnees {

    static Map< Class<? extends Donnees>, Donnees> classDonneesMap = new HashMap<>();
    private static Gson gson = new GsonBuilder().create();

    public static <D extends Donnees>
        D obtenirDonnees(Class<D> classeDonnees, Bundle etat,File repertoireDonnees) throws IOException {
        GLog.appel(EntrepotDeDonnees.class);

     if(etat != null && siDonneesSontDansEtat(classeDonnees,etat)) {

         return donneesDansEtat(classeDonnees,etat);

     }else{
         if(siDonneesSontSurDisque(classeDonnees,repertoireDonnees)){
             return donneesSurDisque(classeDonnees,repertoireDonnees);
         }else {

             if (siDonneesSontDansEntrepot(classeDonnees)) {
                 return donneesDansEntrepot(classeDonnees);
             } else {

                 D donnees = creerDonnees(classeDonnees);
                 entreposerDonnees(donnees);
                 return donnees;
             }
         }

     }
    }
    private static<D extends Donnees> D donneesDansEntrepot(Class<? extends Donnees> classeDonnees){
        GLog.appel(EntrepotDeDonnees.class);
       return (D) classDonneesMap.get(classeDonnees);

    }
    private static boolean siDonneesSontDansEntrepot(Class<? extends Donnees> classeDonnees){
        GLog.appel(EntrepotDeDonnees.class);
        Boolean bool = classDonneesMap.containsKey(classeDonnees);
        return bool;

    }
    private static<D extends Donnees> D creerDonnees(Class<D> classeDonnees){
        GLog.appel(EntrepotDeDonnees.class);
        try {

            D donnees = classeDonnees.newInstance();
            return donnees;
        }catch(IllegalAccessException | InstantiationException e){

        }
            return null;
    }
    private static<D extends Donnees> void entreposerDonnees(D donnees){
        GLog.appel(EntrepotDeDonnees.class);
        classDonneesMap.put(donnees.getClass(),donnees);
    }
    public static <D extends Donnees> void sauvegarderDonnees(D donnees, Bundle etat){
        GLog.appel(EntrepotDeDonnees.class);

        String stringDonnee = gson.toJson(donnees);

        etat.putString(clePourClasseDonnees(donnees.getClass()),stringDonnee);
        GLog.valeurs("Données sauvegardées : ", clePourClasseDonnees(donnees.getClass()), stringDonnee);

    }

    private static String clePourClasseDonnees(Class<? extends Donnees>classeDonnee) {
        GLog.appel(EntrepotDeDonnees.class);
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

    public static <D extends Donnees> void sauvegarderSurDisque(D donnees, File repertoireDonnees) throws IOException {
        GLog.appel(EntrepotDeDonnees.class);

        FileOutputStream output = new FileOutputStream(repertoireDonnees+"/"+nomFichierPourClasseDonnees(donnees.getClass()));
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(output));
        buf.write(gson.toJson(donnees));
        buf.close();


    }

    private static String nomFichierPourClasseDonnees(Class<? extends Donnees> classeDonnees){
        GLog.appel(EntrepotDeDonnees.class);
        String nomFichier = classeDonnees+".json";
        return nomFichier;
    }

    private static File fichierDonnees(Class<? extends Donnees> classeDonnees, File repertoireDonnees){
        GLog.appel(EntrepotDeDonnees.class);
        File fichier = new File(repertoireDonnees+"/"+nomFichierPourClasseDonnees(classeDonnees));
        return fichier;

    }
    private static boolean siDonneesSontSurDisque(Class<? extends Donnees> classeDonnees, File repertoireDonnees){
        GLog.appel(EntrepotDeDonnees.class);
        File temp;
        boolean exists = false;
        try
        {
            temp = fichierDonnees(classeDonnees,repertoireDonnees);

             exists = temp.exists();


        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return exists;
    }
    private static <D extends Donnees> D donneesSurDisque(Class<D> classeDonnees, File repertoireDonnees) throws IOException {
        GLog.appel(EntrepotDeDonnees.class);
        D donnees = null;

        File fichier = fichierDonnees(classeDonnees,repertoireDonnees);
        FileReader readerFichier = new FileReader(fichier);

        donnees = gson.fromJson(readerFichier, classeDonnees);


        String chaineJson = gson.toJson(donnees);


        GLog.valeurs("Données chargées du disque: ", classeDonnees, chaineJson);
        return donnees;
    }

}
