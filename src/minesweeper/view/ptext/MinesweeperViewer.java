package minesweeper.view.ptext;

import java.util.Arrays;
import minesweeper.core.*;

public class MinesweeperViewer {
    
    private char[][] table;
    private MinesweeperHideMask minesweeperHideMask;
    
    public MinesweeperViewer(MinesweeperState state) {
        this.minesweeperHideMask = new MinesweeperHideMask(state);
        this.table = state.getTable();
        applyHideMask();
    }
    
    public void show(){
        String string = "   ";
        for (int i = 0; i < table[0].length; i++) {
            string += i+", ";
        }
        for (int i = 0; i < table.length; i++) {
            string += "\n"+i+" "+Arrays.toString(table[i]);
        }
        System.out.println(string);
    }
    
    public void update(MinesweeperState state){
        this.table = state.getTable();
        applyHideMask();
    }

    private void applyHideMask() {
        boolean[][] hideTable = minesweeperHideMask.getHideTable();
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[0].length; j++)
                if(hideTable[i][j])this.table[i][j]=' ';      
    }
}