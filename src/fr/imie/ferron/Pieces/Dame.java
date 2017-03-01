package fr.imie.ferron.Pieces;

import fr.imie.ferron.Echiquier.Case;
import fr.imie.ferron.Echiquier.Echiquier;
import fr.imie.ferron.Exceptions.ExceptionPosition;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Dame extends Piece{
    public Dame(Position position, Couleur couleur) {
        super(position, couleur);
    }
    @Override
    public boolean positionPossible(Position position) throws ExceptionPosition {
        if(position.getX() >= 1 && position.getX() <=8 && position.getY() <=8 && position.getY()>=1) { //Vérification nom sorti du plateau

            if(this.getPosition().getX() != position.getX() && this.getPosition().getY() == position.getY()){
                int indice = Math.abs(this.getPosition().getX()-position.getX());
                for(int i=1;i<indice;i++){
                    if(Echiquier.getInstance().getPiece(new Position(this.getPosition().getY(),position.getX()+i)) != null){
                        throw new ExceptionPosition();
                    }
                }
            }
            else {
                if(this.getPosition().getY() != position.getY() && this.getPosition().getX() == position.getX()){
                    int indice = Math.abs(this.getPosition().getY()-position.getY()), i =1;
                    System.out.println(indice);

                    while(Echiquier.getInstance().getPiece(new Position(this.getPosition().getY()+i,position.getX())) != null && i<indice){
                        if(Echiquier.getInstance().getPiece(new Position(this.getPosition().getY()+i,position.getX())).getCouleur() == this.getCouleur()){
                            throw new ExceptionPosition();
                        }
                        if(!Echiquier.getInstance().getPiece(new Position(this.getPosition().getY()+i,position.getX())).memePosition(position)){
                            throw new ExceptionPosition();
                        }
                        i++;
                    }

//                    for(int i = 1;i<indice;i++){
//                        if(Echiquier.getInstance().getPiece(new Position(this.getPosition().getY()+i,position.getX())) !=null
//                                && this.getCouleur() == Echiquier.getInstance().getPiece(new Position(this.getPosition().getY()+i,position.getX())).getCouleur()){
//                            throw new ExceptionPosition();
//                        }
//                    }
                }
                return true;
            }
        }
        throw new ExceptionPosition();
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
