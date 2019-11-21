package ca.cours5b5.davidlavigueur.donnees;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import ca.cours5b5.davidlavigueur.global.GLog;
import ca.cours5b5.davidlavigueur.global.GUsagerCourant;

public class EntrepotDeDonnees {

    static Map< Class<? extends Donnees>, Donnees> classDonneesMap = new HashMap<>();
    private static Gson gson = new GsonBuilder().create();
    private static FirebaseFirestore firestore = FirebaseFirestore.getInstance();


    public static <D extends Donnees>
        void obtenirDonnees(final Class<D> classeDonnees, final RetourDonnees<D> retourDonnees)  {

        GLog.appel(EntrepotDeDonnees.class);

     /*if(etat != null && siDonneesSontDansEtat(classeDonnees,etat)) {

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

     }*/
        chargerDonneesDuServeur(classeDonnees, new RetourChargement<D>() {
            @Override
            public void chargementReussi(D donnees) {
                retourDonnees.recevoirDonnees((D) donnees);
            }

            @Override
            public void chargementEchoue() {
                retourDonnees.recevoirDonnees(creerDonnees(classeDonnees));
            }
        });
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

            throw  new RuntimeException(e);

        }
    }
    public static<D extends Donnees> void entreposerDonnees(D donnees){
        GLog.appel(EntrepotDeDonnees.class);
        GLog.valeurs(donnees);
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

    public static <D extends Donnees> void sauvegarderSurDisque(D donnees, File repertoireDonnees)  {
        GLog.appel(EntrepotDeDonnees.class);
        try {
            FileOutputStream output = new FileOutputStream(repertoireDonnees + "/" + nomFichierPourClasseDonnees(donnees.getClass()));
            BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(output));
            buf.write(gson.toJson(donnees));
            buf.close();
        }catch(IOException e){
            e.printStackTrace();
        }

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
    private static <D extends Donnees> D donneesSurDisque(Class<D> classeDonnees, File repertoireDonnees) {
        GLog.appel(EntrepotDeDonnees.class);
        D donnees = null;
        try {
            File fichier = fichierDonnees(classeDonnees, repertoireDonnees);
            FileReader readerFichier = new FileReader(fichier);

            donnees = gson.fromJson(readerFichier, classeDonnees);


           String chaineJson = gson.toJson(donnees);


          GLog.valeurs("Données chargées du disque: ", classeDonnees, chaineJson);
        }catch(FileNotFoundException e){

            e.printStackTrace();
        }
        return donnees;
    }
    private static String nomCollection(Class<? extends Donnees> classeDonnees){
        GLog.appel(EntrepotDeDonnees.class);
        return classeDonnees.getSimpleName();
    }
    private static String idDocument(){
        GLog.appel(EntrepotDeDonnees.class);
      return GUsagerCourant.getId();
    }
    private static DocumentReference referenceDocument(Class<? extends Donnees> classesDonnees){
        GLog.appel(EntrepotDeDonnees.class);
        DocumentReference documentReference = firestore.collection(nomCollection(classesDonnees)).document(idDocument());
        return documentReference;
    }
    public static <D extends Donnees> void sauvegarderDonneesSurServeur(D donnees){
        GLog.appel(EntrepotDeDonnees.class);
        DocumentReference documentReference = referenceDocument(donnees.getClass());
        documentReference.set(donnees);
    }
    private static <D extends Donnees> void reagirDonneesChargees(RetourChargement<D> retourChargement,
                                                                  @Nullable D donnees){
        GLog.appel(EntrepotDeDonnees.class);
        if(donnees != null){
            retourChargement.chargementReussi(donnees);
        }else{
            retourChargement.chargementEchoue();
        }

    }
    private static <D extends Donnees> void reagirDocumentCharge(Class<D> classeDonnees,RetourChargement<D> retourChargement,
                                                                 DocumentSnapshot documentSnapshot){
        GLog.appel(EntrepotDeDonnees.class);
        if(documentSnapshot.exists()){
            D donnees = documentSnapshot.toObject(classeDonnees);
            reagirDonneesChargees(retourChargement,donnees);
        }else{
            retourChargement.chargementEchoue();
        }

    }
    private static <D extends Donnees> void installerCapteursServeur(final Class<D> classeDonnees,
                                                                     final RetourChargement<D> retourChargement,
                                                                     Task<DocumentSnapshot> promessesServeurs){
        GLog.appel(EntrepotDeDonnees.class);
        promessesServeurs.addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>(){

            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot){
                reagirDocumentCharge(classeDonnees,retourChargement,documentSnapshot);
            }


        });
        promessesServeurs.addOnFailureListener(new OnFailureListener(){

            @Override
            public void onFailure(@NonNull Exception e){
                retourChargement.chargementEchoue();
            }

        });


    }
    private static <D extends Donnees> void chargerDonneesDuServeur(final Class<D> classeDonnees, final RetourChargement<D> retourChargement){
        GLog.appel(EntrepotDeDonnees.class);
        DocumentReference documentReference = referenceDocument(classeDonnees);
        Task<DocumentSnapshot> promessesServeur = documentReference.get();
        installerCapteursServeur(classeDonnees,retourChargement,promessesServeur);


    }


}
