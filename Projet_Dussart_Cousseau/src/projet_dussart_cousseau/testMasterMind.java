/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_dussart_cousseau;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author alice
 */
public class testMasterMind {
    
    ArrayList<Character> couleursDisponibles = new ArrayList<>();
    public testMasterMind(){
        couleursDisponibles.add('R');
        couleursDisponibles.add('G');
        couleursDisponibles.add('B');
        couleursDisponibles.add('Y');
    }
       
    public void testComparer(){
    Pion[] tabPion1 = {new Pion('R'),new Pion('G'),new Pion('B'),new Pion('Y')};
 
    Combinaison c1 = new Combinaison(tabPion1);
    Combinaison c2 = new Combinaison(4);
    c2.genererAleatoire(4,couleursDisponibles);

    int[] reponses = c1.comparer(c2);
    System.out.println("combinaison choisie : "+ c1);
    System.out.println("combinaison aleatoire : "+ c2);

    System.out.println("resultats (bien places, mal places) : " + Arrays.toString(reponses)); 
    

    }    
    public void testCombinaison(){
        Combinaison combi = new Combinaison(4);
        combi.genererAleatoire(4, couleursDisponibles);
        System.out.println("Combinaison aleatoire de 4 couleurs : "+ combi.toString());
    }
    
    public void testPion() {
        
               
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



    public void testPlateauDeJeu() {
  
    Pion[] pionsSecrete = {new Pion('R'), new Pion('G'), new Pion('B'), new Pion('Y')};
    Combinaison combinaisonSecrete = new Combinaison(pionsSecrete);

    PlateauDeJeu plateau = new PlateauDeJeu(combinaisonSecrete, 10);

    System.out.println("Début du test du plateau de jeu :\n");

    Pion[] tentative1 = {new Pion('B'), new Pion('G'), new Pion('R'), new Pion('Y')};
    plateau.proposerCombinaison(new Combinaison(tentative1));
    plateau.afficherPlateau();
    System.out.println("Victoire ? " + plateau.estVictoire());
    System.out.println("Défaite ? " + plateau.estDefaite() + "\n");

    Pion[] tentative2 = {new Pion('R'), new Pion('G'), new Pion('B'), new Pion('Y')};
    plateau.proposerCombinaison(new Combinaison(tentative2));
    plateau.afficherPlateau();
    System.out.println("Victoire ? " + plateau.estVictoire());
    System.out.println("Défaite ? " + plateau.estDefaite() + "\n");
  }




    public void testPartie() {
        System.out.println("=== Lancement d'une partie complète ===");
        int tailleCombinaison = 4;
        int nbToursMax = 10;

        Partie partie = new Partie(tailleCombinaison, nbToursMax, couleursDisponibles);

        partie.afficherRegles();

        partie.lancerPartie();

        partie.terminerPartie();
    }
}
 
    
    
    
