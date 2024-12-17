/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_dussart_cousseau;

import java.util.ArrayList;

/**
 *
 * @author doria
 */
public class PlateauDeJeu {
    Combinaison combinaisonSecrete;
    ArrayList <Combinaison> tentatives;
    Combinaison combiEnCours;
    ArrayList <String> reponses;
    ArrayList <Integer> réponsesbienplace;
    ArrayList <Integer> réponsesmalplace;
     
    ArrayList<Character> couleursDisponibles;
    int nbToursMax=12;
    int longeurCombi=4;
    boolean affichereponse =false;

    public PlateauDeJeu( ArrayList couleursDispo, Combinaison combinaisonSecrete, int nbToursMax, int longueurCombi) {
        this.couleursDisponibles = couleursDispo;
        this.combinaisonSecrete = combinaisonSecrete;
        this.combiEnCours = new Combinaison(4);
        this.nbToursMax = nbToursMax;
        this.longeurCombi = longueurCombi;
        this.tentatives = new ArrayList<>();
        this.reponses = new ArrayList<>();
        this.réponsesbienplace = new ArrayList<>();
        this.réponsesmalplace = new ArrayList<>();
        affichereponse=false;
        
    }
    
        public PlateauDeJeu(Combinaison combinaisonSecrete, int nbToursMax) {
        this.combinaisonSecrete = combinaisonSecrete;
        this.nbToursMax = nbToursMax;
        this.tentatives = new ArrayList<>();
        this.reponses = new ArrayList<>();
        affichereponse=false;

    }
        
        
public void proposerCombinaison(Combinaison tentative){
       tentatives.add(tentative);
 
        int[] indices = combinaisonSecrete.comparer(tentative);
        combiEnCours = new Combinaison(longeurCombi);
        
        String reponse = indices[0] + " noirs, " + indices[1] + " blancs";
        reponses.add(reponse);
        réponsesbienplace.add(indices[0]);
        réponsesmalplace.add(indices[1]);
    }

public void afficherPlateau(){
    System.out.println("État actuel du plateau :");
        for (int i = 0; i < tentatives.size(); i++) {
            System.out.println("Tentative " + (i + 1) + ": " + tentatives.get(i).toString() + " -> Réponse : " + reponses.get(i));
        }
}
public boolean estVictoire(){
   if (!tentatives.isEmpty()) {
            Combinaison derniereTentative = tentatives.get(tentatives.size() - 1);
            int[] indices = combinaisonSecrete.comparer(derniereTentative);
            return indices[0] == combinaisonSecrete.toString().length(); // Toutes les couleurs bien placées
        }
        return false;
    }
public boolean estDefaite(){
  return tentatives.size() >= nbToursMax && !estVictoire();  
}
}
