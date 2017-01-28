package fr.imie.ferron;

import java.util.ArrayList;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Main {
    public static void main(String[] args) throws ExceptionPosition {
        Position p1 = new Position(1,2);
        Position p2 = new Position(5,2);
        Position p3 = new Position(4,4);
        Dame d = new Dame(p1,Couleur.BLANC);
        Roi r = new Roi(p2,Couleur.NOIR);
        Pion p = new Pion(p3,Couleur.NOIR);



        Echiquier echec = new Echiquier();
        echec.ajouterPiece(d);
        echec.ajouterPiece(p);
        echec.ajouterPiece(r);
        echec.afficher();
        p.deplacement(new Position(5,4));
        echec.supprimerPiece(p);
        echec.ajouterPiece(p);
        echec.afficher();
//        echec.afficher();

    }
}
