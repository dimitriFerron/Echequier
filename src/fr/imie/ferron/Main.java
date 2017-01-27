package fr.imie.ferron;

import java.util.ArrayList;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Main {
    public static void main(String[] args) {
        Position p1 = new Position(1,2);
        Position p2 = new Position(5,2);
        Position p3 = new Position(4,4);
        Dame d = new Dame(p1,'N');
        Roi r = new Roi(p2,'N');
        Pion p = new Pion(p3,'N');



        Echiquier echec = new Echiquier();
        echec.ajouterPiece(d);
        echec.ajouterPiece(p);
        echec.ajouterPiece(r);

        System.out.println(echec.getPiece(p2));
        echec.afficher();
    }
}
