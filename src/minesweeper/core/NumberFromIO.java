package minesweeper.core;

import java.io.*;

public class NumberFromIO {
    
public static int numberFromIO(){        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        String numberFIO = "";
        try {numberFIO = br.readLine();}
        catch (IOException ex) {mensajeError(1);}
        try{number = Integer.parseInt(numberFIO);}
        catch(Exception e){mensajeError(1);}
        return number;
    }

public static int[] pairFromIO(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = {0,0};
        String numbersFIO = "";
        try {numbersFIO = br.readLine();}
        catch (IOException ex) {mensajeError(2);}
        try{
        numbers[0] = Integer.parseInt((numbersFIO.split(" "))[0]);
        numbers[1] = Integer.parseInt((numbersFIO.split(" "))[1]);
        }catch(Exception e){mensajeError(2);}
        return numbers;
    }

    private static void mensajeError(int a) {
        String mensaje = "Formato de entrada erroneo";
        switch(a){
            case 1: mensaje += "Debe escribir tan sólo un número entero"; break;
            case 2: mensaje += "Debe escribir dos número esnteros separados por un espacio\n"
                    + "p.e. \"8 9\""; break;
            //Unsuported cases
        }
        throw new UnsupportedOperationException(mensaje);
    }
}

    
