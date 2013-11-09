package minesweeper.view.ptext;

import minesweeper.core.*;
import minesweeper.core.support.*;

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

    public XYLocation askMove() {
        XYLocation move = new XYLocation();
        System.out.println("¿Que posicion quieres marcar ahora?");
        System.out.println("Formato: \"[+|-] %fila %columna\"");
        move = NumberFromIO.pairFromIO();
        return move;
    }
}
