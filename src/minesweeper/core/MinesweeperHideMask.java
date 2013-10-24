package minesweeper.core;

public class MinesweeperHideMask {
    private boolean[][] hideTable;

    public MinesweeperHideMask(boolean[][] hideTable) {
        this.hideTable = hideTable;
    }
    
    public MinesweeperHideMask(char[][] table) {
        hideTable = new boolean[table.length][table[0].length];
        for (int i = 0; i < table.length; i++) 
            for (int j = 0; j < table[0].length; j++) 
                hideTable[i][j] = true;                   
    }
    
    public MinesweeperHideMask(MinesweeperState state) {
        this(state.getTable());
    }
    

    public boolean[][] getHideTable(){
        return hideTable.clone();
    }
    
    public void unHide(int[] position){                       
                hideTable[position[0]][position[1]]=false;
    }
    
    public void unHide(int[][] pattern){
        for (int i = 0; i < pattern.length; i++)
            unHide(pattern[i]);
    }
    
    
}
