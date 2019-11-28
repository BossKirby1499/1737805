package ca.cours5b5.davidlavigueur.commandes;

public abstract class Commande {

 public abstract void executer();

 public boolean siExecutable(){

     return true;
 }
}
