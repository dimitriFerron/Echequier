package fr.imie.ferron;

import fr.imie.ferron.Position;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public abstract class Piece {

    private Position position;
    private char couleur;

    public Piece(Position position, char couleur) {
        this.position = position;
        this.couleur = couleur;
    }
    public abstract boolean positionPossible(Position position);
    public abstract String getSymbole();
    public abstract int getValeur();
    public abstract void deplacement(Position position);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public char getCouleur() {
        return couleur;
    }

    public void setCouleur(char couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Piece: "+
                getSymbole()+
                ", position: " + getPosition() +
                ", couleur: " + getCouleur() + '\'' +
                '}';
    }
}
