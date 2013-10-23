
package minesweeper;

import java.util.Arrays;

public class MinesweeperViewer {
    
    char[][] table;

    public MinesweeperViewer(MinesweeperState state) {
        table = state.getTable();
        
    }//
    
    public void show(){
        String string = "";
        for (int i = 0; i < table.length; i++) {
            string += Arrays.toString(table[i]) + "\n";
        }
        System.out.println(string);
    }
    
    public void update(MinesweeperState state){
        table = state.getTable();
    }
}