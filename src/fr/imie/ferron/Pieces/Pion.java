package fr.imie.ferron.Pieces;

import fr.imie.ferron.Echiquier.Case;
import fr.imie.ferron.Echiquier.Echiquier;
import fr.imie.ferron.Exceptions.ExceptionPosition;

import java.util.ArrayList;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Pion extends Piece{
    public Pion(Position position, Couleur couleur) {
        super(position,couleur);
    }
    public void positions(){
        Position pos;
        if (this.getCouleur() == Couleur.BLANC) {
            pos = new Position(this.getPosition().getY()+1,this.getPosition().getX());
            if(Echiquier.getInstance().getPiece(pos) == null) {
                this.getPositionsPossible().add(pos);
                if (this.getPosition().getY() == 2) {
                    this.getPositionsPossible().add(new Position(this.getPosition().getY() + 2, this.getPosition().getX()));
                }
            }
            pos = new Position(this.getPosition().getY()+1,this.getPosition().getX()+1);
            if(Echiquier.getInstance().getPiece(pos) != null && !this.getCouleur().equals(Echiquier.getInstance().getPiece(pos))) {
                    this.getPositionsPossible().add(pos);
            }
            pos = new Position(this.getPosition().getY()+1,this.getPosition().getX()-1);
            if(Echiquier.getInstance().getPiece(pos) != null && !this.getCouleur().equals(Echiquier.getInstance().getPiece(pos))) {
                this.getPositionsPossible().add(pos);
            }
        } else {
            pos =new Position(this.getPosition().getY()-1,this.getPosition().getX());
            if(Echiquier.getInstance().getPiece(pos) == null) {
                this.getPositionsPossible().add(pos);
                if (this.getPosition().getY() == 7) {
                    this.getPositionsPossible().add(new Position(this.getPosition().getY() - 2, this.getPosition().getX()));
                }
            }
            pos = new Position(this.getPosition().getY()-1,this.getPosition().getX()+1);
            if(Echiquier.getInstance().getPiece(pos) != null && !this.getCouleur().equals(Echiquier.getInstance().getPiece(pos))) {
                this.getPositionsPossible().add(pos);
            }
            pos = new Position(this.getPosition().getY()-1,this.getPosition().getX()-1);
            if(Echiquier.getInstance().getPiece(pos) != null && !this.getCouleur().equals(Echiquier.getInstance().getPiece(pos))) {
                this.getPositionsPossible().add(pos);
            }
        }
    }
    public boolean positionPossible(Position position) throws ExceptionPosition {
        if(position.getX() >= 1 && position.getX() <=8 && position.getY() <=8 && position.getY()>=1) {
            if(Echiquier.getInstance().getPiece(position) == null) {
                if (this.getCouleur() == Couleur.BLANC) {
                    Position pos = new Position(position.getY()-1,position.getX());
                    if (this.memePosition(pos) || this.memePosition(new Position(position.getY()-2,position.getX()))) {
                        System.out.println();
                        return true;
                    }
                } else {
                    if (this.getCouleur() == Couleur.NOIR) {
                        Position pos = new Position(position.getY()+1,position.getX());
                        if (this.memePosition(pos) || this.memePosition(new Position(position.getY()+2,position.getX()))) {
                            return true;
                        }
                    }
                }
            }
            else{
                if (this.getCouleur() == Couleur.BLANC) {
                    Position posTempo = new Position(position.getY() - 1,position.getX()+1);
                    Position posTempo2 = new Position(position.getY() - 1,position.getX()-1);
                    if(this.memePosition(posTempo) || this.memePosition(posTempo2)) {
                        if (Echiquier.getInstance().getPiece(position) != null && Echiquier.getInstance().getPiece(position).getCouleur() != this.getCouleur()) {
                            Echiquier.getInstance().supprimerPiece(Echiquier.getInstance().getPiece(position));
                            return true;
                        }
                    }
                } else {
                    if (this.getCouleur() == Couleur.NOIR) {
                        Position posTempo = new Position(position.getY() + 1,position.getX()+1);
                        Position posTempo2 = new Position(position.getY() + 1,position.getX()-1);
                        if((this.memePosition(posTempo) || this.memePosition(posTempo2)) && Echiquier.getInstance().getPiece(position) !=null
                                && Echiquier.getInstance().getPiece(position).getCouleur() != this.getCouleur()){
                            Echiquier.getInstance().supprimerPiece(Echiquier.getInstance().getPiece(position));
                            return true;
                        }
                    }
                }
            }
        }
        throw new ExceptionPosition();
    }
    @Override
    public String getSymbole() {
        return "P";
    }
    @Override
    public int getValeur() {
        return 1;
    }
    @Override
    public void deplacement(Case btn) throws ExceptionPosition{
        if(positionPossible(btn.getPos())){
            Position pos = new Position(this.getPosition().getY(),this.getPosition().getX());
            this.setPosition(btn.getPos());
            btn.setPiece(this);
            btn.setText(this.getSymbole());

        }
    }
}
