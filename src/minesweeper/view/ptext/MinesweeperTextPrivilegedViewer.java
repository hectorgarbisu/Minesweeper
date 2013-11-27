package minesweeper.view.ptext;

import java.util.Arrays;
import minesweeper.core.*;
//Clase en peligro de extinción
public class MinesweeperTextPrivilegedViewer {

    private MinesweeperState state;

    public MinesweeperTextPrivilegedViewer(MinesweeperState state) {
        this.state = state;
    }

    public MinesweeperTextPrivilegedViewer(MinesweeperGame game) {
        this(game.getState());
    }

    public void show() {
        String string = "  ";
        for (int i = 0; i < state.tableWidth; i++) {
            string += String.format("%3d", i);
        }
        for (int i = 0; i < state.tableHeight; i++) {
            string += "\n" + String.format("%2d", i) + " " + Arrays.toString(state.getRawRow(i)) + String.format("%2d", i);
        }
        System.out.println(string);
    }

    public void refresh(MinesweeperState state) {
        this.state = state;
    }

    public void refresh(MinesweeperGame game) {
        refresh(game.getState());
    }
}