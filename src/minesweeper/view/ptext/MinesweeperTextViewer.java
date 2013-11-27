package minesweeper.view.ptext;

import java.util.Arrays;
import minesweeper.core.*;
import minesweeper.view.MinesweeperGameViewer;

public class MinesweeperTextViewer implements MinesweeperGameViewer {
    
    private MinesweeperState state;
    
    public MinesweeperTextViewer(MinesweeperState state) {
        this.state = state;
    }    
    public MinesweeperTextViewer(MinesweeperGame game) {
        this(game.getState());
    }
    
    
    @Override
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

    @Override
    public void refresh(MinesweeperGame game) {
        refresh(game.getState());
    }

    @Override
    public void showMines() {
        state.showMines();
        show();
    }

}