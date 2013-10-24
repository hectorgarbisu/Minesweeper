package minesweeper.control;
import minesweeper.core.*;
import minesweeper.view.ptext.*;

public class MinesweeperControl {
    private MinesweeperState minesweeperState;
    private MinesweeperViewer minesweeperViewer;
    private MinesweeperGameDialog minesweeperGameDialog;
    private MinesweeperPrivilegedViewer minesweeperPrivilegedViewer;
    
    public MinesweeperControl() {
    }
    
    public void execute(){
       minesweeperState = new MinesweeperState(getInitialValues());
       minesweeperGameDialog = new MinesweeperGameDialog();
       //minesweeperViewer = new MinesweeperViewer(minesweeperState);
       minesweeperPrivilegedViewer = new MinesweeperPrivilegedViewer(minesweeperState);
       //minesweeperViewer.show();
       minesweeperPrivilegedViewer.show();
       while(!minesweeperState.isTerminal())
          play();
       if(minesweeperState.hasWon())System.out.println("You won");
       else System.out.println("You lost");
    }

    private int[] getInitialValues() {        
       MinesweeperInitializeDialog minesweeperInitializeDialog = new MinesweeperInitializeDialog();
       minesweeperInitializeDialog.execute();
       int[] values = new int[3];
       values[0] = minesweeperInitializeDialog.getX();
       values[1] = minesweeperInitializeDialog.getY();
       values[2] = minesweeperInitializeDialog.getNumberOfMines();
       return values;
    }
    
    private void play(){
        int[] move = new int[2];                   
        move = minesweeperGameDialog.askMove();
        minesweeperState.makeMove(move);
        minesweeperPrivilegedViewer.show();
    }

    private void anotherGo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
