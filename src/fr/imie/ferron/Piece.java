package fr.imie.ferron;

import fr.imie.ferron.Position;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public abstract class Piece {

    private Position position;
    private Couleur couleur;

    public Piece(Position position, Couleur couleur) {
        this.position = position;
        this.couleur = couleur;
    }
    public abstract boolean positionPossible(Position position) throws ExceptionPosition;
    public abstract String getSymbole();
    public abstract int getValeur();
    public abstract void deplacement(Position position) throws ExceptionPosition;

    public Position getPosition() {
        return position;
    }
    public boolean memePosition(Position pos){
        return this.getPosition().getX() == pos.getX() && this.getPosition().getY()==pos.getY();
    }

    public void setPosition(Position position) {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return "Piece: "+
                getSymbole()+
                ", position: " + position.getX()+", " +position.getY()+
                ", couleur: " + getCouleur() + '\'' +
                '}';
    }
}
