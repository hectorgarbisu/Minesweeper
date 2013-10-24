package minesweeper.core;

public class MinesweeperState {
    private boolean victory;
    private char[][] table;

    public char[][] getTable() {
        return table.clone();
    }
   
    public MinesweeperState(int width, int height) {
        victory = false;
        table = new char[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) table[i][j] = ' ';
    }
   
    public MinesweeperState(int width, int height,int numberOfMines) {
        this(width,height);
        table = MinesweeperMinesPutter.putMines(table, numberOfMines);
    }
    public MinesweeperState(int[] initialValuesArray){
        this(initialValuesArray[0],initialValuesArray[1],initialValuesArray[2]);
    }

    public MinesweeperState() {
        this(8,8);
    }
    
    public boolean isTerminal(){
        boolean isComplete = true;
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[i].length; j++){
                if(table[i][j] == ' ') isComplete = false;
                if(table[i][j] == 'D') {
                    victory = false;
                    return true;
                }
            }
        victory = true;
        return isComplete;
    }
    
    public boolean hasWon(){
        return victory;
    }

    public void makeMove(int[] move) {
        if(move[0]<table.length)
        if(move[1]<table[0].length)
        if(table[move[0]][move[1]]==' '){
            mark(move);
        }
        else if(table[move[0]][move[1]]=='M')
            die(move);
    }

    private void mark(int[] move) {
        table[move[0]][move[1]] = 'X';
    }

    private void die(int[] move) { 
        table[move[0]][move[1]] = 'D';
    }

}
