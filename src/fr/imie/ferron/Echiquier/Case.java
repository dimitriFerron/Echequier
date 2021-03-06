package fr.imie.ferron.Echiquier;

import fr.imie.ferron.Pieces.Piece;
import fr.imie.ferron.Pieces.Position;

import javax.swing.*;

/**
 * Created by ferron.cdi04 on 01/03/2017.
 */
public class Case extends JButton{
    private Piece piece;
    private Position pos;
    public Case(Piece piece,Position pos){
        super(piece.getSymbole());
        this.piece = piece;
        this.pos = pos;
    }
    public Case(Position pos){
        super();
        this.pos = pos;
    }
    public Piece getPiece(){
        return piece;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    public void setPos(Position pos) {
        this.pos = pos;
    }
       public Position getPos(){
        return pos;
    }

}
