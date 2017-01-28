package fr.imie.ferron;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Main {

    private Pion pN2 = new Pion(new Position(2, 2), Couleur.NOIR);
    private Pion pN3 = new Pion(new Position(2, 3), Couleur.NOIR);
    private Pion pN4 = new Pion(new Position(2, 4), Couleur.NOIR);
    private Pion pN5 = new Pion(new Position(2, 5), Couleur.NOIR);
    private Pion pN6 = new Pion(new Position(2, 6), Couleur.NOIR);
    private Pion pN7 = new Pion(new Position(2, 7), Couleur.NOIR);
    private Pion pN8 = new Pion(new Position(2, 8), Couleur.NOIR);



    private Pion pB5 = new Pion(new Position(7, 5), Couleur.BLANC);
    private Pion pB6 = new Pion(new Position(7, 6), Couleur.BLANC);
    private Pion pB7 = new Pion(new Position(7, 7), Couleur.BLANC);
    private Pion pB8 = new Pion(new Position(7, 8), Couleur.BLANC);

    public static void main(String[] args) throws ExceptionPosition {
        Pion pB1 = new Pion(new Position(3, 3), Couleur.BLANC);
        Pion pB2 = new Pion(new Position(2, 4), Couleur.NOIR);
         Pion pB5 = new Pion(new Position(2, 2), Couleur.NOIR);
         Pion pB3 = new Pion(new Position(2, 3), Couleur.NOIR);
         Pion pB4 = new Pion(new Position(7, 4), Couleur.BLANC);
//        Pion pN1 = new Pion(new Position(2, 2), Couleur.NOIR);


        try {
//            Main main = new Main();
//            main.initialization();
            Echiquier.getInstance().ajouterPiece(pB2);
            Echiquier.getInstance().ajouterPiece(pB1);
            Echiquier.getInstance().ajouterPiece(pB5);
            Echiquier.getInstance().ajouterPiece(pB4);
            Echiquier.getInstance().ajouterPiece(pB3);
            Echiquier.getInstance().afficher();
            pB1.deplacement(new Position(2,3));
            Echiquier.getInstance().afficher();


        }catch (ExceptionPosition e){}
    }
    public void initialization()throws ExceptionPosition{



        Echiquier.getInstance().ajouterPiece(pB5);
        Echiquier.getInstance().ajouterPiece(pB6);
        Echiquier.getInstance().ajouterPiece(pB7);
        Echiquier.getInstance().ajouterPiece(pB8);

        Echiquier.getInstance().ajouterPiece(pN2);
        Echiquier.getInstance().ajouterPiece(pN3);
        Echiquier.getInstance().ajouterPiece(pN4);
        Echiquier.getInstance().ajouterPiece(pN5);
        Echiquier.getInstance().ajouterPiece(pN6);
        Echiquier.getInstance().ajouterPiece(pN7);
        Echiquier.getInstance().ajouterPiece(pN8);

        Echiquier.getInstance().afficher();
    }
}
