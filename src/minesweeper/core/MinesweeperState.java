package minesweeper.core;
import minesweeper.core.support.XYLocation;
import minesweeper.core.tool.*;

public class MinesweeperState {
    private boolean victory;
    private char[][] table;
    private MinesweeperHideMask minesweeperHideMask;
    
    public MinesweeperState mineSweeperState(MinesweeperState state){
        MinesweeperState newState;
        newState = new MinesweeperState(state.getTable()[0].length,state.getTable().length);
        return newState;        
    }
    
    public  MinesweeperState(int width, int height) {
        victory = false;
        table = new char[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) table[i][j] = ' ';
    }
   
    private MinesweeperState(int width, int height,int numberOfMines) {
        this(width,height);
        minesweeperHideMask = new MinesweeperHideMask(table);
        table = MinesweeperMinePutter.putMines(table, numberOfMines);
        table = MinesweeperNumberPutter.putNumbers(table);
    }
    public MinesweeperState(int[] initialValuesArray){
        this(initialValuesArray[0],initialValuesArray[1],initialValuesArray[2]);
    }

    public MinesweeperState() {
        this(8,8);
    }

    public char[][] getTable() {
        char[][] tableCopy = new char[table.length][table[0].length];
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[i].length; j++)
                tableCopy[i][j] = table[i][j];
        return tableCopy;
    }
    
  
    public int getWidth(){
        return table[0].length;
    }
    
    public int getHeight(){
        return table.length;
    }
    
    public boolean isTerminal(){
        boolean isComplete = true;
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[i].length; j++){
                if(table[i][j] == ' '||table[i][j]=='0') isComplete = false;
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

    public void makeMove(XYLocation move) {
        if(move.getY()<table.length)
        if(move.getX()<table[0].length)
        if(table[move.getY()][move.getX()]==' '
                ||table[move.getY()][move.getX()]=='0'
                ||table[move.getY()][move.getX()]=='#'){
            footPrint(move);
        }
        else if(table[move.getY()][move.getX()]=='M')
            die(move);
        else{
            minesweeperHideMask.unHide(move);
        }
    }
    
    private void footPrint(XYLocation move) {
        MinesweeperRecursiveUnhider minesweeperRecursiveUnhider = new MinesweeperRecursiveUnhider(this);
        minesweeperRecursiveUnhider.doRecursiveUnhiding(move);     
        minesweeperHideMask.unHide(minesweeperRecursiveUnhider.getUnhidenLocations());
        /*for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if((table[i][j]==' ')&&minesweeperHideMask.isShown(i,j)){
                    table[i][j]='#';
                }
            }
        }*/
        //minesweeperHideMask.unHide(move);
    }
    
    private void die(XYLocation move) { 
        table[move.getY()][move.getX()] = 'D';
        minesweeperHideMask.unHide(move);
    }

    public char[][] getHidenTable() {
        char[][] hidenTable = getTable(); 
        boolean[][] hideTable = minesweeperHideMask.getHideTable();
        for (int i = 0; i < hidenTable.length; i++)
            for (int j = 0; j < hidenTable[i].length; j++)
                if(hideTable[i][j])hidenTable[i][j]=' ';      
        return hidenTable;
    }

}

            
    


