package fr.imie.ferron.Pieces;

import fr.imie.ferron.Echiquier.Case;
import fr.imie.ferron.Exceptions.ExceptionPosition;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public abstract class Piece implements Serializable{

    private Position position;
    private Couleur couleur;
    private ArrayList<Position> positionsPossible;

    public Piece(Position position, Couleur couleur) {
        this.position = position;
        this.couleur = couleur;
        positionsPossible = new ArrayList<>();
    }
    public abstract boolean positionPossible(Position position) throws ExceptionPosition;
    public abstract String getSymbole();
    public abstract int getValeur();
    public abstract void deplacement(Case btn) throws ExceptionPosition;
    public abstract void positions();
    public Position getPosition() {
        return position;
    }
    public boolean memePosition(Position pos){
        return this.getPosition().getX() == pos.getX() && this.getPosition().getY()==pos.getY();
    }

    public ArrayList<Position> getPositionsPossible() {
        return positionsPossible;
    }

    public void setPositionsPossible(ArrayList<Position> positionsPossible) {
        this.positionsPossible = positionsPossible;
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
