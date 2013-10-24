package minesweeper.view.ptext;

import java.util.Arrays;
import minesweeper.core.*;

public class MinesweeperPrivilegedViewer {
    
    private char[][] table;

    public MinesweeperPrivilegedViewer(MinesweeperState state) {
        this.table = state.getTable();        
    }
    
    public void show(){
        String string = "   ";
        for (int i = 0; i < this.table[0].length; i++) {
            string += i+", ";
        }
        for (int i = 0; i < table.length; i++) {
            string += "\n"+i+" "+Arrays.toString(table[i]);
        }
        System.out.println(string);
    }
    
    public void update(MinesweeperState state){
        this.table = state.getTable();
    }
}