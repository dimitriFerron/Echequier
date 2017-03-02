package fr.imie.ferron.Pieces;

import fr.imie.ferron.Echiquier.Case;
import fr.imie.ferron.Echiquier.Echiquier;
import fr.imie.ferron.Exceptions.ExceptionPosition;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Cavalier extends Piece{
    public Cavalier(Position position, Couleur couleur) {
        super(position, couleur);
    }
    @Override
    public boolean positionPossible(Position position) throws ExceptionPosition {
        // toutes les positions possible par apport à celle d'avant
        Position p1 = new Position(position.getY()-1,position.getX()-2);
        Position p2 = new Position(position.getY()+1,position.getX()-2);
        Position p3 = new Position(position.getY()+2,position.getX()-1);
        Position p4 = new Position(position.getY()-2,position.getX()-1);
        Position p5 = new Position(position.getY()+1,position.getX()+2);
        Position p6 = new Position(position.getY()-1,position.getX()+2);
        Position p7 = new Position(position.getY()+2,position.getX()+1);
        Position p8 = new Position(position.getY()-2,position.getX()+1);
        if(position.getX() >= 1 && position.getX() <=8 && position.getY() <=8 && position.getY()>=1) { //Vérification nom sorti du plateau
            if(Echiquier.getInstance().getPiece(position)!= null) {
                if (Echiquier.getInstance().getPiece(position).getCouleur() != this.getCouleur()) { //Si la pièce est de l'autre couleur
                    // Si une des 8 possibilité de mouvement
                    if (this.memePosition(p1) || this.memePosition(p2) || this.memePosition(p3) || this.memePosition(p4) || this.memePosition(p5)
                            || this.memePosition(p6) || this.memePosition(p7) || this.memePosition(p8)) {
                        return true;
                    }
                }
            } else {
                if(this.memePosition(p1) || this.memePosition(p2) || this.memePosition(p3) || this.memePosition(p4) || this.memePosition(p5)
                        || this.memePosition(p6)|| this.memePosition(p7) || this.memePosition(p8)){
                    return true;
                }
            }
        }
        throw new ExceptionPosition();
    }
    @Override
    public String getSymbole() {
        return "C";
    }
    @Override
    public int getValeur() {
        return 3;
    }
    @Override
    public void deplacement(Case btn) throws ExceptionPosition{
        if(positionPossible(btn.getPos())){
            this.setPosition(btn.getPos());
            btn.setPiece(this);
            btn.setText(this.getSymbole());
        }
    }

    @Override
    public void positions() {
        Position positions[] = new Position[8];
        positions[0] = new Position(this.getPosition().getY()-1,this.getPosition().getX()-2);
        positions[1] = new Position(this.getPosition().getY()+1,this.getPosition().getX()-2);
        positions[2] = new Position(this.getPosition().getY()+2,this.getPosition().getX()-1);
        positions[3] = new Position(this.getPosition().getY()-2,this.getPosition().getX()-1);
        positions[4] = new Position(this.getPosition().getY()+1,this.getPosition().getX()+2);
        positions[5] = new Position(this.getPosition().getY()-1,this.getPosition().getX()+2);
        positions[6] = new Position(this.getPosition().getY()+2,this.getPosition().getX()+1);
        positions[7] = new Position(this.getPosition().getY()-2,this.getPosition().getX()+1);
        for (Position pos: positions) {
            if(Echiquier.getInstance().getPiece(pos) == null){
                this.getPositionsPossible().add(pos);
            }
            if(Echiquier.getInstance().getPiece(pos) != null && !Echiquier.getInstance().getPiece(pos).getCouleur().equals(this.getCouleur())){
                this.getPositionsPossible().add(pos);
            }
        }


    }
}
