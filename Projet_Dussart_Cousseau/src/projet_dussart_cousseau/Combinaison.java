package projet_dussart_cousseau;

import java.util.ArrayList;
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
    private Pion[] elements;
    
    public  Combinaison(int taille){
         this.taille = taille;
         this.elements = new Pion[taille];
    
    }

    public  Combinaison(Pion[] elements){
     this.elements = elements;
    
    }
    public void genererAleatoire(int taille, ArrayList<Character>couleursDisponibles){
    
        Random random = new Random();
        for (int i = 0; i<4; i++){
            elements[i] = new Pion(couleursDisponibles.get(random.nextInt(4)));
        }
    }
        
    public void comparer(Combinaison autre){
    }
       
    @Override
    public String toString() {
        
        String txt="";
        for (int i=0; i<elements.length;i++)
            txt += elements[i].toString();
        
        return txt;
    }
    
}

  
    
        
    

