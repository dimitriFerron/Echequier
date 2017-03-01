package fr.imie.ferron.Echiquier;

import fr.imie.ferron.Exceptions.ExceptionPosition;
import fr.imie.ferron.Pieces.Piece;
import fr.imie.ferron.Pieces.Position;

import javax.swing.*;
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
    private Piece pieceClick;
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        btn = ((Case)actionEvent.getSource());
        button = Echiquier.getInstance().getButton();

        if(btn.getPiece() != null){
            btn.getPiece().setPositionsPossible(new ArrayList<>());
            positions = btn.getPiece().getPositionsPossible();
            pieceClick = btn.getPiece();
        }



        if(btn.getPiece() == null){
            for (Position pos: positions) {
                if (btn.getPos().getX() == pos.getX() && btn.getPos().getY() == pos.getY()){
                    try {
                        System.out.println(pieceClick);
                        pieceClick.deplacement(btn);
                        Echiquier.getInstance().afficherGrille(Echiquier.getInstance().getButton());
                    } catch (ExceptionPosition exceptionPosition) {
                        exceptionPosition.printStackTrace();
                    }
                }
            }
//            System.out.println(btn.getPiece());
        } else {
            Echiquier.getInstance().afficherGrille(Echiquier.getInstance().getButton());
            btn.getPiece().positions();
//            System.out.println(((Case) actionEvent.getSource()).getPiece().getPositionsPossible());

            for (Case btn : button) {
                for (Position pos : positions) {
//                System.out.println(pos);
//                System.out.println(btn.getPos());
                    if (btn.getPos().getX() == pos.getX() && btn.getPos().getY() == pos.getY()) {
                        System.out.println("btn " + btn.getPos() + " pos " + pos);
                        btn.setBackground(Color.RED);
                    }
                }
            }
        }
    }
}
