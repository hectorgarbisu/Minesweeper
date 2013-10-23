package minesweeper;

public class MinesweeperState {
    
    private char[][] table;

    public char[][] getTable() {
        return table;
    }
   
    public MinesweeperState(int width, int height) {
        table = new char[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) table[i][j] = 'a';
    }
   
    public MinesweeperState(int width, int height,int numberOfMines) {
        this(width,height);
    }

    public MinesweeperState() {
        this(8,8);
    }
  
  
}
