package minesweeper;

import minesweeper.control.*;
import minesweeper.core.MinesweeperGame;
import minesweeper.view.MinesweeperGameDialog;
import minesweeper.view.MinesweeperGameViewer;
import minesweeper.view.MinesweeperInitializeDialog;
import minesweeper.view.gui.MinesweeperGuiInitializeDialog;
import minesweeper.view.ptext.MinesweeperTextDialog;
import minesweeper.view.ptext.MinesweeperTextInitializeDialog;
import minesweeper.view.ptext.MinesweeperTextViewer;

public class Minesweeper {

    public static final boolean GUI = false;

    public static void main(String[] args) {
        MinesweeperGame minesweeperGame = new MinesweeperGame(getInitialValues());
        MinesweeperGameDialog dialog;
        MinesweeperGameViewer viewer;
        if (GUI){ 
            //dialog = new MinesweeperGraphicDialog;
            //viewer = new MinesweeperGraphicViewer;
        }
        else {
            dialog = new MinesweeperTextDialog();
            viewer = new MinesweeperTextViewer(minesweeperGame);
        }
        MinesweeperControl minesweeperControl = new MinesweeperControl(minesweeperGame, dialog, viewer);
        minesweeperControl.execute();


    }

    private static int[] getInitialValues() {
        MinesweeperInitializeDialog minesweeperInitializeDialog;
        minesweeperInitializeDialog = new MinesweeperGuiInitializeDialog();
       /* if (GUI) ;//minesweeperInitializeDialog = new MinesweeperGuiInitializeDialog();
        else minesweeperInitializeDialog = new MinesweeperTextInitializeDialog();*/
        minesweeperInitializeDialog.execute();
        return minesweeperInitializeDialog.getValues();
    }
}