package fr.imie.ferron;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Cavalier extends Piece{
    public Cavalier(Position position, char couleur) {
        super(position, couleur);
    }
    @Override
    public boolean positionPossible(Position position) {
        return false;
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
    public void deplacement(Position position) {
        if(positionPossible(position)){
            this.setPosition(position);
        }
    }
}
