package projet_dussart_cousseau;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author doria
 */
public class Pion {
    private Character couleur;

    public Pion(Character couleur) {
        this.couleur = couleur;
    }

    public Character getCouleur() {
        return couleur;
    }

  public void setCouleur(Character couleur) {
        this.couleur = couleur;
    }
  
   @Override 
    public String toString() {
        return couleur.toString();
    }
}
 
     
     


