/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_dussart_cousseau;

import java.util.ArrayList;

/**
 *
 * @author alice
 */
public class testMasterMind {
    
    public static void testCombinaison(){
        ArrayList<Character> couleursDisponibles = new ArrayList<>();
        couleursDisponibles.add('R');
        couleursDisponibles.add('V');
        couleursDisponibles.add('B');
        couleursDisponibles.add('Y');
       
       
        Combinaison combi = new Combinaison(4);
        combi.genererAleatoire(4, couleursDisponibles);
        System.out.println("combinaison aleatoire de 4 couleurs : "+ combi.toString());
    }
    
    public static void testPion() {
        
               
    Pion pionRouge = new Pion('R');//red
    Pion pionBleu = new Pion('B');//blue
    Pion pionVert = new Pion('G');//green
    Pion pionJaune = new Pion('Y');//yellow
    Pion pionBlanc = new Pion('W');//white
    Pion pionNoir = new Pion('B');//black
    
    //test des accesseurs
    System.out.println("Couleur du pion rouge : " + pionRouge.getCouleur()); 
    System.out.println("Couleur du pion bleu : " + pionBleu.getCouleur());   
    System.out.println("Couleur du pion vert : " + pionVert.getCouleur());   
    System.out.println("Couleur du pion jaune : " + pionJaune.getCouleur());
    
    //test méthode toString
    System.out.println("Affichage du pion rouge : " + pionRouge); 
    System.out.println("Affichage du pion bleu : " + pionBleu);   
    System.out.println("Affichage du pion vert : " + pionVert);
    System.out.println("Affichage du pion jaune : " + pionJaune);
    }

}
