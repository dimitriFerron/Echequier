package fr.imie.ferron.Pieces;

import fr.imie.ferron.Echiquier.Case;
import fr.imie.ferron.Exceptions.ExceptionPosition;

/**
 * Created by ferron.cdi04 on 01/03/2017.
 */
public class Fou extends Piece {
    public Fou(Position position, Couleur couleur) {
        super(position, couleur);
    }
    @Override
    public boolean positionPossible(Position position) throws ExceptionPosition {
        return true;
    }
    @Override
    public String getSymbole() {
        return "F";
    }
    @Override
    public int getValeur() {
        return 3;
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