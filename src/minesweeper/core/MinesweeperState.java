package minesweeper.core;
import minesweeper.core.support.XYLocation;
import minesweeper.core.tool.*;

public class MinesweeperState {
    public int tableWidth;
    public int tableHeight;
    private MinesweeperCell[][] table;
    
    public MinesweeperState mineSweeperState(MinesweeperState state){
        MinesweeperState newState;
        newState = new MinesweeperState(state.getRawTable()[0].length,state.getRawTable().length);
        return newState;        
    }
    
    public  MinesweeperState(int width, int height) {
        tableWidth = width;
        tableHeight = height;
        table = new MinesweeperCell[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) table[i][j] = new MinesweeperCell();
    }
   
    private MinesweeperState(int width, int height,int numberOfMines) {
        this(width,height);
        table = MinesweeperMinePutter.putMines(table, numberOfMines);
        table = MinesweeperNumberPutter.putNumbers(table);
    }
    public MinesweeperState(int[] initialValuesArray){
        this(initialValuesArray[0],initialValuesArray[1],initialValuesArray[2]);
    }

    public MinesweeperState() {
        this(8,8);
    }

    public char[][] getRawTable() {
        char[][] tableCopy = new char[table.length][table[0].length];
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[i].length; j++)
                tableCopy[i][j] = table[i][j].getValue();
        return tableCopy;
    }
    
    public MinesweeperCell[][] getTable() {
        return table;
    }
  
    public int getWidth(){
        return table[0].length;
    }
    
    public int getHeight(){
        return table.length;
    }
    
    public void flagPosition(XYLocation position) {
        if(position.getY()<table.length)
        if(position.getX()<table[0].length)
        if(!table[position.getY()][position.getX()].isVisible())
            table[position.getY()][position.getX()].setFlagged(true);
            
    }
    
    public void makeMove(XYLocation move) {
        if(move.getY()<table.length)
        if(move.getX()<table[0].length)
        if(table[move.getY()][move.getX()].getValue()=='#'
                ||table[move.getY()][move.getX()].getValue()=='0'){
                //||table[move.getY()][move.getX()].getValue()=='#'){
            footPrint(move);
        }
        else if(table[move.getY()][move.getX()].getValue()=='M')
            die(move);
        else{
            table[move.getY()][move.getX()].setVisible(true);
            table[move.getY()][move.getX()].setFlagged(false);
        }
    }
    
    private void footPrint(XYLocation move) {
        table = MinesweeperRecursiveUnhider.doRecursiveUnhiding(table,move);     
    }
    
    private void die(XYLocation move) { 
        table[move.getY()][move.getX()].setValue('D');
        table[move.getY()][move.getX()].setVisible(true);
    }

    public char[] getRawRow(int rowNumber) {
      char[] rowValues = new char[tableWidth];
      for(int i=0;i<tableWidth;i++){
          rowValues[i] = table[rowNumber][i].getValue();
      }
      return rowValues;
    }
    
    public char[] getFixedRow(int rowNumber) {
      char[] rowValues = new char[tableWidth];
      for(int i=0;i<tableWidth;i++){
          if(table[rowNumber][i].isVisible())
            rowValues[i] = table[rowNumber][i].getValue();
          if(table[rowNumber][i].isFlagged())
             rowValues[i] = 'F';
      }
      return rowValues;
    }
    
    public char[] getMinedRow(int rowNumber) {
      char[] rowValues = new char[tableWidth];
      for(int i=0;i<tableHeight;i++){
          if(table[rowNumber][i].getValue()=='M')
          rowValues[i] = 'M';
          else if(table[rowNumber][i].getValue()=='D')
          rowValues[i] = 'D';
          else
          rowValues[i] = ' ';
      }
      return rowValues;
    }

    public void showMines() {
        return;
    }



}

            
    


