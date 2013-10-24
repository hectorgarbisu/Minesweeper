package minesweeper.view.ptext;

import minesweeper.core.*;

public class MinesweeperGameDialog {
    private int markX;
    private int markY;

    public int getMarkX() {
        return markX;
    }

    public int getMarkY() {
        return markY;
    }
    public void MinesweeperGameDialog() {

    }
    
    public void execute(){
        
    }

    public int[] askMove() {
        int[] move = {0,0};
        System.out.println("¿Que posicion quieres marcar ahora?");
        System.out.println("Formato: \"[+|-] %fila %columna\"");
        move = NumberFromIO.pairFromIO();
        return move;
    }
}
