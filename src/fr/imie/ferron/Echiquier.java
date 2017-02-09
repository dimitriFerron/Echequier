package fr.imie.ferron;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ferron on 28/01/2017.
 */
public class Echiquier implements Serializable{
    private static Echiquier ourInstance = new Echiquier();
    private ArrayList<Piece> echec = new ArrayList<Piece>();

    public static Echiquier getInstance() {
        return ourInstance;
    }

    private Echiquier() {
    }
    public void ajouterPiece(Piece p)throws ExceptionPosition{
        if(p.getPosition().getX() >= 1 && p.getPosition().getX() <=8
                && p.getPosition().getY() <=8 && p.getPosition().getY()>=1) {
            if(Echiquier.getInstance().getPiece(p.getPosition()) == null){
                echec.add(p);
            } else {
                throw new ExceptionPosition("Une pièce est déjà à cette emplacement");
            }
        } else{
            throw new ExceptionPosition();
        }
    }
    public Piece getPiece(Position p){
        for (Piece piece: echec
                ) {
            if(piece.memePosition(p)){
                return piece;
            }
        }
        return null;
    }
    public void supprimerPiece(Piece p ){
        echec.remove(p);
    }
    public int getPoints(Couleur couleur){
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
        for ( int i =1;i <9; i++){
            for (int j=1;j <9; j++){
                plateau[indice] = new Position(i,j);
                indice++;
            }
        }
        indice = 0;
        System.out.println("  | A | B | C | D | E | F | G | H |");
        System.out.print(afficherInterligne());

        for ( int i =1;i <9; i++){
            System.out.print(i+" | ");
            for (int j=1;j <9; j++){
                if(getPiece(plateau[indice]) == null) {
                    System.out.print("  | ");
                }else{
                    System.out.print(getPiece(plateau[indice]).getSymbole()+" | ");

                }
                indice++;
            }
            System.out.println();
            System.out.print(afficherInterligne());
        }
    }
    public void sauvegarder()throws IOException{
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
    public void chargement() throws  IOException{
        ObjectInputStream objectInputStream = null;

        try{
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Echequier.txt"))));
            echec.addAll((Piece)objectInputStream.readObject());
            objectInputStream.close();

        } catch (IOException e){
            System.out.println("Chargement fail");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

    }
}
