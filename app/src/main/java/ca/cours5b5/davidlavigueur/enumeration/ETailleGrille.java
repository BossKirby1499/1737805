package ca.cours5b5.davidlavigueur.enumeration;

public enum ETailleGrille {

    petite,
    moyenne,
    grande;

   public static int getHauteur(ETailleGrille hauteur){

        if(hauteur == petite){
            return 3;
        }else if(hauteur == moyenne){
            return 4;
        }else{
            return 5;
        }

    }
    public static int getLargeur(ETailleGrille largeur){

        if(largeur == petite){
            return 3;
        }else if(largeur == moyenne){
            return 4;
        }else{
            return 5;
        }
    }


}
