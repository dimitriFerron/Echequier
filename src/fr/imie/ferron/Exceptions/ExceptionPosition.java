package fr.imie.ferron.Exceptions;

/**
 * Created by ferron on 28/01/2017.
 */
public class ExceptionPosition extends Exception{
    public ExceptionPosition(){
        System.out.println("Mouvement impossible");
    }
    public ExceptionPosition(String message){
        System.out.println(message);
    }


}
