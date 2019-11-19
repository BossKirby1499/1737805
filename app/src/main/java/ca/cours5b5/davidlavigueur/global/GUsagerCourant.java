package ca.cours5b5.davidlavigueur.global;

import com.firebase.ui.auth.data.model.User;
import com.google.firebase.auth.FirebaseAuth;

public class GUsagerCourant {
    public static boolean siConnecte(){



        return  FirebaseAuth.getInstance().getUid() != null;

    }
    public static String getId(){

       if(FirebaseAuth.getInstance().getCurrentUser() == null){
           return "defaut";
       }else{
           return FirebaseAuth.getInstance().getCurrentUser().getUid();
       }
    }
}
