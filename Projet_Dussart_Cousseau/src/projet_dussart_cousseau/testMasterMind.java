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



    public static void main(String[] args) {
        System.out.println("=== Tests PlateauDeJeu ===");

        testInitialisationPlateau();
        testProposerCombinaison();
        testVictoire();
        testDefaite();
        testAfficherPlateau();
    }

    private static void testInitialisationPlateau() {
        System.out.println("\nTest 1 : Initialisation du plateau");
        Combinaison combinaisonSecrete = new Combinaison(new Pion[]{
            new Pion('R'), new Pion('B'), new Pion('G'), new Pion('Y')
        });

        PlateauDeJeu plateau = new PlateauDeJeu(combinaisonSecrete, 10);

        if (plateau == null) {
            System.out.println("Échec : Le plateau ne doit pas être null après initialisation.");
        } else {
            System.out.println("Succès : Plateau initialisé correctement.");
        }
    }

    private static void testProposerCombinaison() {
        System.out.println("\nTest 2 : Proposer une combinaison");
        Combinaison combinaisonSecrete = new Combinaison(new Pion[]{
            new Pion('R'), new Pion('B'), new Pion('G'), new Pion('Y')
        });

        PlateauDeJeu plateau = new PlateauDeJeu(combinaisonSecrete, 10);

        Combinaison tentative = new Combinaison(new Pion[]{
            new Pion('R'), new Pion('B'), new Pion('Y'), new Pion('G')
        });

        plateau.proposerCombinaison(tentative);

        if (plateau.estVictoire()) {
            System.out.println("Échec : Le joueur ne devrait pas gagner pour cette tentative.");
        } else {
            System.out.println("Succès : La combinaison a été ajoutée correctement.");
        }
    }

    private static void testVictoire() {
        System.out.println("\nTest 3 : Condition de victoire");
        Combinaison combinaisonSecrete = new Combinaison(new Pion[]{
            new Pion('R'), new Pion('B'), new Pion('G'), new Pion('Y')
        });

        PlateauDeJeu plateau = new PlateauDeJeu(combinaisonSecrete, 10);

        Combinaison tentative = new Combinaison(new Pion[]{
            new Pion('R'), new Pion('B'), new Pion('G'), new Pion('Y')
        });

        plateau.proposerCombinaison(tentative);

        if (plateau.estVictoire()) {
            System.out.println("Succès : Victoire détectée correctement.");
        } else {
            System.out.println("Échec : La victoire n'a pas été détectée.");
        }
    }

    private static void testDefaite() {
        System.out.println("\nTest 4 : Condition de défaite");
        Combinaison combinaisonSecrete = new Combinaison(new Pion[]{
            new Pion('R'), new Pion('B'), new Pion('G'), new Pion('Y')
        });

        PlateauDeJeu plateau = new PlateauDeJeu(combinaisonSecrete, 1);

        Combinaison tentative = new Combinaison(new Pion[]{
            new Pion('R'), new Pion('G'), new Pion('B'), new Pion('Y')
        });

        plateau.proposerCombinaison(tentative);

        if (plateau.estDefaite()) {
            System.out.println("Succès : Défaite détectée correctement.");
        } else {
            System.out.println("Échec : La défaite n'a pas été détectée.");
        }
    }

    private static void testAfficherPlateau() {
        System.out.println("\nTest 5 : Affichage du plateau");
        Combinaison combinaisonSecrete = new Combinaison(new Pion[]{
            new Pion('R'), new Pion('B'), new Pion('G'), new Pion('Y')
        });

        PlateauDeJeu plateau;
        plateau = new PlateauDeJeu(combinaisonSecrete, 10);

        Combinaison tentative1 = new Combinaison(new Pion[]{
            new Pion('R'), new Pion('G'), new Pion('B'), new Pion('Y')
        });

        Combinaison tentative2 = new Combinaison(new Pion[]{
            new Pion('R'), new Pion('B'), new Pion('G'), new Pion('Y')
        });

        plateau.proposerCombinaison(tentative1);
        plateau.proposerCombinaison(tentative2);

        System.out.println("Affichage attendu :");
        plateau.afficherPlateau();
    }
}
