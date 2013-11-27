package minesweeper.control;
import minesweeper.core.*;
import minesweeper.core.support.XYLocation;
import minesweeper.view.*;
import minesweeper.view.ptext.MinesweeperTextDialog;
import minesweeper.view.ptext.MinesweeperTextInitializeDialog;
import minesweeper.view.ptext.MinesweeperTextPrivilegedViewer;
import minesweeper.view.ptext.MinesweeperTextViewer;

public class MinesweeperControl {
    private MinesweeperGameViewer minesweeperGameViewer;
    private MinesweeperGameDialog minesweeperGameDialog;
    private MinesweeperTextPrivilegedViewer minesweeperPrivilegedViewer;
    private MinesweeperGame minesweeperGame;
    private final static boolean DEV = true;
    
    
    public MinesweeperControl(MinesweeperGame game, MinesweeperGameDialog dialog, MinesweeperGameViewer viewer) {
        minesweeperGame = game;
        minesweeperGameDialog = dialog;
        minesweeperGameViewer = viewer;
    }
    
    public MinesweeperControl(MinesweeperGame game) {
        this(game, new MinesweeperTextDialog(), new MinesweeperTextViewer(game));
    }
    
    public void execute(){
       if(DEV)minesweeperPrivilegedViewer = new MinesweeperTextPrivilegedViewer(minesweeperGame);
       if(DEV)minesweeperPrivilegedViewer.show();
       minesweeperGameViewer.show();
       while(!minesweeperGame.isTerminal())
          play();
       if(minesweeperGame.hasWon())System.out.println("You won");
       else{
           minesweeperGameViewer.showMines();
           System.out.println("You lost");
       }
    }

    
    private void play(){
        minesweeperGameDialog.askAction();
        XYLocation position = minesweeperGameDialog.getPosition();
        if(minesweeperGameDialog.actionIsToFlag()) 
            minesweeperGame.flagPosition(position);
        else
            minesweeperGame.makeMove(position);
        if(DEV)minesweeperPrivilegedViewer.refresh(minesweeperGame);
        minesweeperGameViewer.refresh(minesweeperGame);
        if(DEV)minesweeperPrivilegedViewer.show();
        minesweeperGameViewer.show();
    }  
    
}
