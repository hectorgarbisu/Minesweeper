package minesweeper.view.ptext;

import java.util.Arrays;
import minesweeper.core.*;

public class MinesweeperViewer {
    
    private MinesweeperCell[][] table;
    private MinesweeperState state;
    
    public MinesweeperViewer(MinesweeperCell[][] table){
        this.table=table;
    }
    public MinesweeperViewer(MinesweeperState state) {
        this.state = state;
    }    
    public MinesweeperViewer(MinesweeperGame game) {
        this(game.getState());
    }
    
    
    public void show(){
        String string = "   ";
        for (int i = 0; i < state.tableHeight; i++) {
            string += i+", ";
        }
        for (int i = 0; i < state.tableWidth; i++) {
            string += "\n"+i+" "+Arrays.toString(state.getFixedRow(i));
        }
        System.out.println(string);
    }
    
    public void refresh(MinesweeperState state){
        this.table = state.getTable();
    }

    public void refresh(MinesweeperGame game) {
        refresh(game.getState());
    }

    public void showMines() {
        String string = "   ";
        for (int i = 0; i < state.tableHeight; i++) {
            string += i+", ";
        }
        for (int i = 0; i < state.tableWidth; i++) {
            string += "\n"+i+" "+Arrays.toString(state.getMinedRow(i));
        }
        System.out.println(string);
    }

}