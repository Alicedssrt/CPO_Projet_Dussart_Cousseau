package projet_dussart_cousseau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alice
 */
public class Combinaison {
    private int taille = 4;
    Pion[] elements;
    
    public  Combinaison(int taille){
         this.taille = taille;
         this.elements = new Pion[taille];
              for (int i = 0; i < taille; i++) 
                elements[i] = new Pion('R');
    
    }

    public  Combinaison(Pion[] elements){
     this.elements = elements;
    
    }
    public void genererAleatoire(int taille, ArrayList<Character>couleursDisponibles){
    
        Random random = new Random();
        for (int i = 0; i<taille; i++)
            elements[i] = new Pion(couleursDisponibles.get(random.nextInt(couleursDisponibles.size())));
        
    }
        
    public int [] comparer(Combinaison autre){
           int [] reponses = new int[2]; 
           //index0: nbre pions bien placés (noirs)
           //index1 : nbre pions mal placés (blancs)
           boolean [] marque = new boolean[autre.elements.length];
           for (int i = 0; i < taille; i++) {
                if (this.elements[i].getCouleur().equals(autre.elements[i].getCouleur())) {
            reponses[0]++; // Bien placé
            marque[i] = true; // Marqué comme utilisé
                }
            }
            for (int i = 0; i < taille; i++) {
                if (!this.elements[i].getCouleur().equals(autre.elements[i].getCouleur())) {
                    for (int j = 0; j < taille; j++) {
                        if (!marque[j] && this.elements[i].getCouleur().equals(autre.elements[j].getCouleur())) {
                            reponses[1]++; 
                            marque[j] = true; 
                            break;
                }
            }
        }
    }
    
   
            return reponses;
        }
    
        
    
    @Override
public String toString() {
    String txt = "";
    for (int i = 0; i < elements.length; i++) {
        txt += "*"; // Remplacer la couleur par un caractère générique (ex: étoile)
    }
    return txt;
}

}     
    

