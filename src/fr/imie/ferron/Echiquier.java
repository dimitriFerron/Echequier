package fr.imie.ferron;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Echiquier {
    private ArrayList<Piece> echec = new ArrayList<Piece>();

    public Echiquier() {
        this.echec = echec;
    }
    public void ajouterPiece(Piece p){
        echec.add(p);
    }
    public Piece getPiece(Position p){
        for (Piece piece: echec
             ) {
            if(piece.getPosition() == p){
                return piece;
            }
        }
        return null;
    }
    public int getPoints(char couleur){
        int points = 0;
        for (Piece piece: echec
             ) {
            if(piece.getCouleur() == couleur){
                points += piece.getValeur();
            }
        }
        return points;
    }
    private String afficherInterligne(){
        return "    -------------------------------\n";
    }
    public void afficher(){
        Position plateau[] = new Position[64];
        int indice=0;
        for ( int i =0;i <8; i++){
            for (int j=0;j <8; j++){
                plateau[indice] = new Position(i,j);
                indice++;
            }
        }
        indice = 0;
        System.out.println("   | A | B | C | D | E | F | G | H |");
        System.out.print(afficherInterligne());

        for ( int i =0;i <8; i++){
            System.out.print(i+" | ");
            for (int j=0;j <8; j++){
                System.out.print(getPiece(plateau[indice]));
                if(getPiece(plateau[indice]) == null) {
                    System.out.print("  | ");
                }else{
                    System.out.println("test");
                    System.out.print(getPiece(plateau[indice]).getSymbole()+" | ");

                }
                indice++;
            }
            System.out.println();
            System.out.print(afficherInterligne());
        }
    }
    public void sauvegarder(){
        ObjectOutputStream objectOutputStream = null;

        try{

            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Echequier.txt"))));

            objectOutputStream.writeObject(echec);

            objectOutputStream.close();
        } catch (IOException e){
            System.out.println("Sauvegarde fail");
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        }
    public void chargement() {
        ObjectInputStream objectInputStream = null;

//        try{
//            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Echequier.txt"))));
//            this.echec.addAll((echec)objectInputStream.readObject());
//            objectInputStream.close();
//
//        } catch (IOException e){
//            System.out.println("Chargement fail");
//        } finally {
//            try {
//                objectInputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        };

    }
}
