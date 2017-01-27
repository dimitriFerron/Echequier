package fr.imie.ferron;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Pion extends Piece{
    public Pion(Position position, char couleur) {
        super(position, couleur);
    }

    public boolean positionPossible(Position position) {
        return false;
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
    public void deplacement(Position position) {
        if(positionPossible(position)){
            this.setPosition(position);
        }
    }
}
