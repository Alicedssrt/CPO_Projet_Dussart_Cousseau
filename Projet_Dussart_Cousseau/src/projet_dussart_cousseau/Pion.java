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
    // Attribut pour représenter la couleur du pion
    private Character couleur;

    /**
     * Constructeur qui initialise le pion avec une couleur donnée.
     * @param couleur La couleur du pion (par exemple, 'R' pour rouge, 'B' pour bleu, etc.).
     */
    public Pion(Character couleur) {
        this.couleur = couleur;
    }

    /**
     * Accesseur pour obtenir la couleur du pion.
     * @return La couleur du pion.
     */
    public Character getCouleur() {
        return couleur;
    }

    /**
     * Redéfinition de la méthode toString pour afficher la couleur du pion.
     * @return Une représentation textuelle de la couleur du pion.
     */
   @Override 
    public String toString() {
        return couleur.toString();
    }

    // Méthode principale pour tester la classe Pion
    public static void main(String[] args) {
        // Création de différents objets Pion
        Pion pion1 = new Pion('R');
        Pion pion2 = new Pion('B');
        Pion pion3 = new Pion('V');
        Pion poin4 = new Pion('J');
        Pion poin5 = new Pion('B');
        Pion poin6 = new Pion('N');
        
      

        
    }
}




