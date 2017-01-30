package fr.imie.ferron;

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
    public void deplacement(Position position) throws ExceptionPosition {
        if(positionPossible(position)){
            this.setPosition(position);
        }
    }
}
