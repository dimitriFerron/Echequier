package fr.imie.ferron.Pieces;

import fr.imie.ferron.Echiquier.Case;
import fr.imie.ferron.Echiquier.Echiquier;
import fr.imie.ferron.Exceptions.ExceptionPosition;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Roi extends Piece{

    public Roi(Position position, Couleur couleur) {
        super(position, couleur);
    }
    @Override
    public boolean positionPossible(Position position) throws ExceptionPosition {
        if(position.getX() >= 1 && position.getX() <=8 && position.getY() <=8 && position.getY()>=1) {
            if (Math.abs(position.getX() - this.getPosition().getX()) < 2 && Math.abs(position.getY() - this.getPosition().getY()) < 2) {
                if (Echiquier.getInstance().getPiece(position) == null) {
                    return true;
                } else {
                    if (Echiquier.getInstance().getPiece(position).getCouleur() != this.getCouleur()) {
                        return true;
                    }
                }
            }
        }
        throw new ExceptionPosition();
    }
    @Override
    public String getSymbole() {
        return "R";
    }
    @Override
    public int getValeur() {
        return 20;
    }
    @Override
    public void deplacement(Case btn) throws ExceptionPosition{
        if(positionPossible(btn.getPos())){
            this.setPosition(btn.getPos());
            btn.setText(btn.getPiece().getSymbole());
        }
    }

    @Override
    public void positions() {

    }
}
