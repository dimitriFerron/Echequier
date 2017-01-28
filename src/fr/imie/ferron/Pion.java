package fr.imie.ferron;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Pion extends Piece{
    public Pion(Position position, Couleur couleur) {
        super(position,couleur);
    }

    public boolean positionPossible(Position position) throws ExceptionPosition{
        Position pos = new Position(0,0);
        if(this.getCouleur() == Couleur.BLANC){
            pos.setX(position.getX()+1);
            pos.setY(position.getY());
            if(this.memePosition(pos)){
                return true;
            }
        } else {
            if(this.getCouleur() == Couleur.NOIR){
                pos.setX(position.getX()-1);
                pos.setY(position.getY());
                if(this.memePosition(pos)){
                    return true;
                }
            }
        }
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
    public void deplacement(Position position) throws ExceptionPosition{
        if(positionPossible(position)){
            this.setPosition(position);
        }
    }
}
