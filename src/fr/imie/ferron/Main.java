package fr.imie.ferron;

import java.io.IOException;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Main {
    public static void main(String[] args) throws ExceptionPosition {

//        Pion pB2 = new Pion(new Position(2, 4), Couleur.NOIR);
//        Pion pB5 = new Pion(new Position(2, 2), Couleur.NOIR);
//        Pion pB3 = new Pion(new Position(2, 3), Couleur.NOIR);
        Pion pB2 = new Pion(new Position(6, 4), Couleur.BLANC);
        Pion pB3 = new Pion(new Position(4, 5), Couleur.NOIR);
        Roi r = new Roi(new Position(4,4),Couleur.NOIR);
        Pion pB1 = new Pion(new Position(3, 3), Couleur.BLANC);
        try {
            Echiquier.getInstance().ajouterPiece(r);
            Echiquier.getInstance().ajouterPiece(pB1);
            Echiquier.getInstance().ajouterPiece(pB2);
//            Echiquier.getInstance().ajouterPiece(pB4);
            Echiquier.getInstance().ajouterPiece(pB3);
//            Echiquier.getInstance().afficher();
//            pB1.deplacement(new Position(2,3));
            Echiquier.getInstance().afficher();
            r.deplacement(new Position(3,3));
            Echiquier.getInstance().afficher();

        }catch (ExceptionPosition e){
            System.out.println("Exception");
        }
    }
}
