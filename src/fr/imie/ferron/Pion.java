package fr.imie.ferron;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Pion extends Piece{
    public Pion(Position position, Couleur couleur) {
        super(position,couleur);
    }

    public boolean positionPossible(Position position) throws ExceptionPosition{
        if(position.getX() >= 1 && position.getX() <=8 && position.getY() <=8 && position.getY()>=1) {
            if(Echiquier.getInstance().getPiece(position) == null) {

                if (this.getCouleur() == Couleur.BLANC) {
                    Position pos = new Position(position.getX()+1,position.getY());
                    if (this.memePosition(pos)) {
                        return true;
                    }
                } else {
                    if (this.getCouleur() == Couleur.NOIR) {
                        Position pos = new Position(position.getX()-1,position.getY());
                        if (this.memePosition(pos)) {
                            return true;
                        }
                    }
                }
            }
            else{
                if (this.getCouleur() == Couleur.BLANC) {
                    Position posTempo = new Position(position.getX() + 1,position.getY()+1);
                    Position posTempo2 = new Position(position.getX() + 1,position.getY()-1);
                    if(this.memePosition(posTempo) || this.memePosition(posTempo2)) {
                        System.out.println(posTempo.toString()+"   "+ posTempo2.toString()+"   "+position.toString()+"   "+this.getPosition().toString());
                        if (Echiquier.getInstance().getPiece(position) != null && Echiquier.getInstance().getPiece(position).getCouleur() != this.getCouleur()) {
                            Echiquier.getInstance().supprimerPiece(Echiquier.getInstance().getPiece(position));
                            return true;
                        }
                    }
                } else {
                    if (this.getCouleur() == Couleur.NOIR) {
                        Position posTempo = new Position(position.getX() - 1,position.getY()+1);
                        Position posTempo2 = new Position(position.getX() - 1,position.getY()-1);
                        if((this.memePosition(posTempo) || this.memePosition(posTempo2)) && Echiquier.getInstance().getPiece(position) !=null
                                && Echiquier.getInstance().getPiece(position).getCouleur() != this.getCouleur()){
                            Echiquier.getInstance().supprimerPiece(Echiquier.getInstance().getPiece(position));
                            return true;
                        }
                    }
                }
            }
        }
        throw new ExceptionPosition();
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
