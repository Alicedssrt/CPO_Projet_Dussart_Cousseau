/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_dussart_cousseau;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author alice
 */
public class DessinePion extends JButton {
    
 PlateauDeJeu plateau;
 int type;   
 int largeur; // largeur en pixel de la cellule
 int hauteur; // hauteur en pixel de la cellule
 int essai; 
 int pos;
 
 // constructeur (appelé depuis FenetrePrincipale)
 public DessinePion( int type,int l,int h) {
 this.type= type;
 this.largeur = l;
 this.hauteur = h;

 }
 
 public DessinePion(PlateauDeJeu plateau, int essai, int pos, int type,int l,int h) {
 this.plateau = plateau;
 this.type= type;
 this.largeur = l;
 this.hauteur = h;
 this.essai = essai;
 this.pos = pos;
 
 

 }
 // Methode gérant le dessin de la cellule
 @Override
 protected void paintComponent(Graphics g) {
     int size;
     if (plateau.réponsesbienplace == null)
         size = 0;
     else size  = plateau.réponsesbienplace.size();
     
     switch (type) {
         case 1:
             if ((size == essai-1) && (size< plateau.nbToursMax))
             {
                g.setColor(GetColorEncours());
                g.fillOval(4, 4, 22, 22);
             }
             else if (size > essai-1){
                g.setColor(GetColorTentative());
                g.fillOval(4, 4, 22, 22);
             }

             else{
                  g.setColor(Color.black);
                  g.drawOval(10, 10, 10, 10);
             }               
             
             break;
         case 2: //bouton validation
             if (size == essai-1){
                g.setColor(Color.black);
                g.drawString("V", 15, 20);
                }
             break;
         case 3: //Pions réponses
             if (size > essai-1){
                 if (GetColorRéponse() == Color.yellow){
                     g.setColor(Color.white);
                     g.drawOval(12, 12, 6, 6);
                 }
                 else{
                    g.setColor(GetColorRéponse());
                    g.fillOval(12, 12, 6, 6);
                 }
             }
             else {
                 g.setColor(Color.white);
                 g.drawOval(12, 12, 6, 6);
             }
             
             
             break;
         case 4:
             g.setColor(GetColorCombiSecrete());
             g.fillOval(2, 2, 26, 26);
             g.drawString("?", 12, 20);
             break;
         default:
             break;
     }

 }
 
Color GetColor(Character couleur) {
  if (couleur == 'R') return Color.red; //Rouge
  if (couleur == 'G') return Color.green; //Vert
  if (couleur == 'B') return Color.blue; //Bleu
  if (couleur == 'Y') return Color.yellow; //Jaune
  if (couleur == 'P') return Color.pink; //Rose
  if (couleur == 'O') return Color.orange; //Orange
  if (couleur == 'W') return Color.white; //Blanc      
  return Color.black;
}
 
Color GetColorTentative(){
     Character couleur = 'B';
     Combinaison combi;
     int size = plateau.tentatives.size();
     if (size >= essai){
          combi = plateau.tentatives.get(essai-1); 
          couleur = combi.elements[pos].getCouleur();
     }
          
     
     
     return GetColor(couleur);
}
 
Color GetColorEncours(){
     Character couleur = 'B';

     couleur = plateau.combiEnCours.elements[pos].getCouleur();
     
     return GetColor(couleur);
}

Color GetColorRéponse(){
     Character couleur = 'Y';
     int numBP,numMP;
     int size = plateau.réponsesbienplace.size();
     if (size >= essai){
          numBP = plateau.réponsesbienplace.get(essai-1);
          numMP = plateau.réponsesmalplace.get(essai-1);
          if (pos-plateau.longeurCombi-1<numBP) return Color.black;
          else if (pos-plateau.longeurCombi-1 < numMP+numBP) return Color.white;
     }
          
     
     return GetColor(couleur);
}

 Color GetColorCombiSecrete(){
     Character couleur = plateau.combinaisonSecrete.elements[pos].getCouleur();
     
     return GetColor(couleur);
 }

}
