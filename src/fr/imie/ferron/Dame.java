package fr.imie.ferron;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Dame extends Piece{
    public Dame(Position position, char couleur) {
        super(position, couleur);
    }
    @Override
    public boolean positionPossible(Position position) {
        return false;
    }
    @Override
    public String getSymbole() {
        return "D";
    }
    @Override
    public int getValeur() {
        return 9;
    }
    @Override
    public void deplacement(Position position) {
        if(positionPossible(position)){
            this.setPosition(position);
        }
    }
}