package fr.imie.ferron.Pieces;

import fr.imie.ferron.Echiquier.Case;
import fr.imie.ferron.Exceptions.ExceptionPosition;

/**
 * Created by ferron.cdi04 on 01/03/2017.
 */
public class Tour extends Piece{
    public Tour(Position position, Couleur couleur) {
        super(position, couleur);
    }
    @Override
    public boolean positionPossible(Position position) throws ExceptionPosition {
       return true;
    }
    @Override
    public String getSymbole() {
        return "T";
    }
    @Override
    public int getValeur() {
        return 5;
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