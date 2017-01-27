package fr.imie.ferron;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Roi extends Piece{

    public Roi(Position position, char couleur) {
        super(position, couleur);
    }
    @Override
    public boolean positionPossible(Position position) {
        return false;
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
    public void deplacement(Position position) {
        if(positionPossible(position)){
            this.setPosition(position);
        }
    }
}
