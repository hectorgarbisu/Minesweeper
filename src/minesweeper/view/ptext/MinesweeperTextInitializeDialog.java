package minesweeper.view.ptext;
import java.io.*;
import minesweeper.view.MinesweeperInitializeDialog;

public class MinesweeperTextInitializeDialog implements MinesweeperInitializeDialog{

    private int x;
    private int y;
    private int numberOfMines;
    
    public MinesweeperTextInitializeDialog() {
        this.x = 8;
        this.y = 8;
        this.numberOfMines = 8;
    }
    @Override
    public int[] getValues(){
        return new int[]{this.x,this.y,this.numberOfMines};
    }
    @Override
    public void execute(){
        System.out.println("BIENVENIDO A MINESWEEPER -1.0 prealfa");
        askDimentions();
        System.out.println("3/3: Introduzca la cantidad de minas que quiere que tenga el tablero (se distribuirán aleatoriamente)");
        this.numberOfMines = numberFromIO();
    }
    
    @Override
    public int getX(){
        return x;
    }
    @Override
    public int getY(){
        return y;
    }
    @Override
    public int getNumberOfMines(){
        return numberOfMines;
    }

    private void askDimentions(){
        System.out.println("Por favor, introduzca los datos de inicialización de la partida");
        System.out.println("1/3: Introduzca el ancho del tablero");
        this.x = numberFromIO();
        System.out.println("2/3: Introduzca la altura del tablero");
        this.y = numberFromIO();
    }
    
    private int numberFromIO() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number;
        String numberFIO = "";
        try {
            numberFIO = br.readLine();}
        catch (IOException ex) {}
        number = Integer.parseInt(numberFIO);
        return number;
    }


    
}
