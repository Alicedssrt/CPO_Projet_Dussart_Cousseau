/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_dussart_cousseau;

/**
 *
 * @author doria
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partie {
    private PlateauDeJeu plateau;
    private ArrayList<Character> couleursDisponibles;

    public Partie(int tailleCombinaison, int nbToursMax, List<Character> couleursDisponibles) {
      
        this.couleursDisponibles = new ArrayList<>(couleursDisponibles);

        Combinaison combinaisonSecrete = new Combinaison(tailleCombinaison);
        combinaisonSecrete.genererAleatoire(tailleCombinaison, this.couleursDisponibles);

        this.plateau = new PlateauDeJeu(combinaisonSecrete, nbToursMax);
    }

    public void afficherRegles() {
        System.out.println("=== Bienvenue dans Mastermind ===");
        System.out.println("Règles du jeu :");
        System.out.println("1. Devinez la combinaison secrète de couleurs.");
        System.out.println("2. Vous recevrez des indices :");
        System.out.println("   - Nombre de pions bien placés (noirs).");
        System.out.println("   - Nombre de pions corrects mais mal placés (blancs).");
        System.out.println("3. Vous avez un nombre limité de tentatives.");
        System.out.println("Les couleurs disponibles sont : " + couleursDisponibles);
        System.out.println("Bonne chance !");
    }

    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);

        afficherRegles();

        while (!plateau.estVictoire() && !plateau.estDefaite()) {
          
            plateau.afficherPlateau();

            System.out.println("Proposez une combinaison (exemple : RGBY) : ");
            String input = scanner.nextLine().toUpperCase();

            if (input.length() != plateau.combinaisonSecrete.toString().length()) {
                System.out.println("Erreur : La combinaison doit contenir " 
                                   + plateau.combinaisonSecrete.toString().length() 
                                   + " couleurs.");
                continue;
            }

            Pion[] pions = new Pion[input.length()];
            for (int i = 0; i < input.length(); i++) {
                char couleur = input.charAt(i);
                if (!couleursDisponibles.contains(couleur)) {
                    System.out.println("Erreur : La couleur " + couleur 
                                       + " n'est pas disponible.");
                    continue;
                }
                pions[i] = new Pion(couleur);
            }

            Combinaison tentative = new Combinaison(pions);
            plateau.proposerCombinaison(tentative);
        }

        terminerPartie();
        scanner.close();
    }

    public void terminerPartie() {
        if (plateau.estVictoire()) {
            System.out.println("Félicitations ! Vous avez trouvé la combinaison secrète.");
        } else {
            System.out.println("Dommage ! Vous avez épuisé toutes vos tentatives.");
            System.out.println("La combinaison secrète était : " + plateau.combinaisonSecrete);
        }
    }
}

