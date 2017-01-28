package fr.imie.ferron;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Roi extends Piece{

    public Roi(Position position, Couleur couleur) {
        super(position, couleur);
    }
    @Override
    public boolean positionPossible(Position position) throws ExceptionPosition {
        if(Math.abs(position.getX()-this.getPosition().getX())<2 && Math.abs(position.getY() - this.getPosition().getY()) < 2){
            if(Echiquier.getInstance().getPiece(position) ==null){
                return true;
            } else {
                if(Echiquier.getInstance().getPiece(position).getCouleur() != this.getCouleur()){
                    return true;
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
    public void deplacement(Position position) throws ExceptionPosition {
        if(positionPossible(position)){
            this.setPosition(position);
        }
    }
}
