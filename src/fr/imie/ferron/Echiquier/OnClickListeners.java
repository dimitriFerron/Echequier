package fr.imie.ferron.Echiquier;

import fr.imie.ferron.Exceptions.ExceptionPosition;
import fr.imie.ferron.Pieces.Piece;
import fr.imie.ferron.Pieces.Position;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ferron.cdi04 on 01/03/2017.
 */
public class OnClickListeners implements ActionListener{
    private Case button[];
    private ArrayList<Position> positions;
    private Case btn;
    private Case btnClick;
    private Piece pieceClick;
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        btn = ((Case)actionEvent.getSource());
        button = Echiquier.getInstance().getButton();
        if(btn.getPiece() != null && btnClick==null){
            btn.getPiece().setPositionsPossible(new ArrayList<>());
            positions = btn.getPiece().getPositionsPossible();
            pieceClick = btn.getPiece();
            btnClick = btn;
        }



        if(btn.getPiece() == null || !btn.getPiece().getCouleur().equals(pieceClick.getCouleur())){
            for (Position pos: positions) {
                if (btn.getPos().getX() == pos.getX() && btn.getPos().getY() == pos.getY()){
                    try {
                        pieceClick.deplacement(btn);
                        btnClick.setPiece(null);
                        btnClick.setText("");
                        btnClick = null;
                        Echiquier.getInstance().refresh(btn);
                    } catch (ExceptionPosition exceptionPosition) {
                        exceptionPosition.printStackTrace();
                    }
                }
            }
        } else {
            changeColor(btn);
        }
    }
    public void changeColor(Case btn){
        button = Echiquier.getInstance().getButton();
        positions = btn.getPiece().getPositionsPossible();
        Echiquier.getInstance().afficherGrille(Echiquier.getInstance().getButton());
        btn.getPiece().positions();

        for (Case butt : button) {
            for (Position pos : positions) {
                if (butt.getPos().getX() == pos.getX() && butt.getPos().getY() == pos.getY()) {
                    butt.setBackground(Color.RED);
                }
            }
        }

    }
}
