package minesweeper.view.ptext;

import java.util.Arrays;
import minesweeper.core.*;

public class MinesweeperViewer {
    
    private MinesweeperState state;
    
    public MinesweeperViewer(MinesweeperState state) {
        this.state = state;
    }    
    public MinesweeperViewer(MinesweeperGame game) {
        this(game.getState());
    }
    
    
    public void show(){
        String numbers,string = "  "; 
        for (int i = 0; i < state.tableWidth; i++) {
            string +=  String.format("%3d",i);
        }
        numbers = string;
        for (int i = 0; i < state.tableHeight; i++) {
            string += "\n"+String.format("%2d",i)+" "+Arrays.toString(state.getFixedRow(i))+String.format("%2d",i);
        }
        string += "\n" + numbers;
        System.out.println(string);
    }
    
    public void refresh(MinesweeperState state){
        this.state = state;
    }

    public void refresh(MinesweeperGame game) {
        refresh(game.getState());
    }

    public void showMines() {
        state.showMines();
        show();
    }

}