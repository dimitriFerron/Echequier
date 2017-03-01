package fr.imie.ferron.Pieces;

import java.io.Serializable;

/**
 * Created by ferron.cdi04 on 27/01/2017.
 */
public class Position implements Serializable{
    private int x;
    private int y;
    public Position(int y, int x){
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
