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
    ArrayList <String> reponses;
    int nbToursMax;

    public PlateauDeJeu(Combinaison combinaisonSecrete, ArrayList<Combinaison> tentatives, ArrayList<String> reponses, int nbToursMax) {
        this.combinaisonSecrete = combinaisonSecrete;
        this.tentatives = tentatives;
        this.reponses = reponses;
        this.nbToursMax = nbToursMax;
    }
public void proposerCombinaison(Combinaison tentative){
    
}
public void estVictoire(){
    
}
public void estDefaite(){
    
}
}
