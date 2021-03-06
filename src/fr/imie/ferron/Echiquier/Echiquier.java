package fr.imie.ferron.Echiquier;

import fr.imie.ferron.Pieces.Couleur;
import fr.imie.ferron.Exceptions.ExceptionPosition;
import fr.imie.ferron.Pieces.*;
import fr.imie.ferron.Pieces.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Echiquier extends JFrame implements Serializable, ActionListener {
    private static Echiquier ourInstance = new Echiquier();
    private ArrayList<Piece> echec;
    private Case button[];
    private OnClickListeners actionListener = new OnClickListeners();
    private JMenuBar menuBar;
    private JMenu fichier;
    private JMenuItem quitter;
    private JMenuItem rejouer ;
    private JMenuItem sauvegarder;
    private File save = new File("Echiquier.txt");

    public static Echiquier getInstance() {
        return ourInstance;
    }
    private Echiquier() {

        // paramètre frame
        WindowListener exitListener = new WindowAdapter(){
            String button[] = {"Quitter et sauvegarder","Quitter sans sauvegarder"};
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        null, "Voulez-vous sauvegarder ?",
                        "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, button, null);
                if (confirm == 0) {
                    try {
                        sauvegarder();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    System.exit(0);
                } else {
                    System.exit(0);
                }
            }
        };
        this.addWindowListener(exitListener);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);

        //menu
        menuBar = new JMenuBar();
        fichier = new JMenu("Fichier");
        sauvegarder = new JMenuItem("Sauvegarder");
        rejouer = new JMenuItem("Rejouer");
        quitter = new JMenuItem("Quitter");

        sauvegarder.addActionListener(this);
        rejouer.addActionListener(this);
        quitter.addActionListener(this);

        fichier.add(rejouer);
        fichier.add(sauvegarder);
        fichier.add(quitter);
        menuBar.add(fichier);

        this.setJMenuBar(menuBar);

        //initilisation
        initialize();
        this.setVisible(true);
    }

    public void initialize() {
        button = new Case[64];
        this.setLayout(new GridLayout(8,8));
        echec = new ArrayList<>();
        if(save.exists()){
            try {
                chargement();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Pion pB1 = new Pion(new Position(2, 1), Couleur.BLANC);
            Pion pB2 = new Pion(new Position(2, 2), Couleur.BLANC);
            Pion pB3 = new Pion(new Position(2, 3), Couleur.BLANC);
            Pion pB4 = new Pion(new Position(2, 4), Couleur.BLANC);
            Pion pB5 = new Pion(new Position(2, 5), Couleur.BLANC);
            Pion pB6 = new Pion(new Position(2, 6), Couleur.BLANC);
            Pion pB7 = new Pion(new Position(2, 7), Couleur.BLANC);
            Pion pB8 = new Pion(new Position(2, 8), Couleur.BLANC);
            Pion pN1 = new Pion(new Position(7, 1), Couleur.NOIR);
            Pion pN2 = new Pion(new Position(7, 2), Couleur.NOIR);
            Pion pN3 = new Pion(new Position(7, 3), Couleur.NOIR);
            Pion pN4 = new Pion(new Position(7, 4), Couleur.NOIR);
            Pion pN5 = new Pion(new Position(7, 5), Couleur.NOIR);
            Pion pN6 = new Pion(new Position(7, 6), Couleur.NOIR);
            Pion pN7 = new Pion(new Position(7, 7), Couleur.NOIR);
            Pion pN8 = new Pion(new Position(7, 8), Couleur.NOIR);

            Dame dB = new Dame(new Position(1, 4), Couleur.BLANC);
            Dame dN = new Dame(new Position(8, 4), Couleur.NOIR);

            Roi rB = new Roi(new Position(1, 5), Couleur.BLANC);
            Roi rN = new Roi(new Position(8, 5), Couleur.NOIR);

            Cavalier cB1 = new Cavalier(new Position(1, 2), Couleur.BLANC);
            Cavalier cB2 = new Cavalier(new Position(1, 7), Couleur.BLANC);
            Cavalier cN1 = new Cavalier(new Position(8, 2), Couleur.NOIR);
            Cavalier cN2 = new Cavalier(new Position(8, 7), Couleur.NOIR);

            Fou fB1 = new Fou(new Position(1, 3), Couleur.BLANC);
            Fou fB2 = new Fou(new Position(1, 6), Couleur.BLANC);
            Fou fN1 = new Fou(new Position(8, 3), Couleur.NOIR);
            Fou fN2 = new Fou(new Position(8, 6), Couleur.NOIR);

            Tour tB1 = new Tour(new Position(1, 1), Couleur.BLANC);
            Tour tB2 = new Tour(new Position(1, 8), Couleur.BLANC);
            Tour tN1 = new Tour(new Position(8, 1), Couleur.NOIR);
            Tour tN2 = new Tour(new Position(8, 8), Couleur.NOIR);


            echec.add(pB1);
            echec.add(pB2);
            echec.add(pB3);
            echec.add(pB4);
            echec.add(pB5);
            echec.add(pB6);
            echec.add(pB7);
            echec.add(pB8);
            echec.add(pN1);
            echec.add(pN2);
            echec.add(pN3);
            echec.add(pN4);
            echec.add(pN5);
            echec.add(pN6);
            echec.add(pN7);
            echec.add(pN8);
            echec.add(dB);
            echec.add(dN);
            echec.add(cB1);
            echec.add(cB2);
            echec.add(cN1);
            echec.add(cN2);
            echec.add(rB);
            echec.add(rN);
            echec.add(tB1);
            echec.add(tB2);
            echec.add(tN1);
            echec.add(tN2);
            echec.add(fB1);
            echec.add(fB2);
            echec.add(fN1);
            echec.add(fN2);
        }
        afficher();
        afficherGrille(getButton());
    }
    public void ajouterPiece(Piece p)throws ExceptionPosition {
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
    public Case getCase(Position p){
        for (Case butt: button
                ) {
            if(butt.getPos().getX() == p.getX() && butt.getPos().getY() == p.getY()){
                return butt;
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

        for (int i =1;i <9; i++) {
            for (int j = 1; j < 9; j++) {
                if (getPiece(plateau[indice]) == null) {
                    button[indice] = new Case(plateau[indice]);
                    button[indice].setEnabled(false);
                } else {
                    button[indice] = new Case(getPiece(plateau[indice]),plateau[indice]);
                }
                button[indice].addActionListener(actionListener);
                this.getContentPane().add(button[indice]);
                indice++;
            }
        }
    }
    public void afficherGrille(Case button[]){
        int indiceColor = 0;
        for (int i =1;i <9; i++){
            for (int j=1;j <9; j++) {
                if (indiceColor % 2 == 0) {
                    button[indiceColor].setBackground(Color.DARK_GRAY);
                    if (i % 2 == 0) {
                        button[indiceColor].setBackground(Color.white);
                    }
                } else {
                    button[indiceColor].setBackground(Color.WHITE);
                    if (i % 2 == 0) {
                        button[indiceColor].setBackground(Color.DARK_GRAY);
                    }
                }
                indiceColor++;

            }
        }
    }
    public void sauvegarder()throws IOException{
        ObjectOutputStream objectOutputStream = null;

        try{

            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(save)));

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
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(save)));
            echec.addAll((ArrayList)objectInputStream.readObject());
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
    public Case[] getButton() {
        return button;
    }
    public void refresh(){
        this.repaint();
        this.revalidate();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == rejouer){
            save.delete();
//            this.removeAll();
            this.initialize();
            this.refresh();
        }
        if(actionEvent.getSource() == sauvegarder){
            try {
                sauvegarder();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(actionEvent.getSource() == quitter){
            System.exit(0);
        }
    }
}
