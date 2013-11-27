package minesweeper.view;

import minesweeper.core.support.XYLocation;

public interface MinesweeperGameDialog {

    public boolean actionIsToFlag();
    public void askAction();
    public XYLocation getPosition();
    
}
