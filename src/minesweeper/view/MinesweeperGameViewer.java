package minesweeper.view;

import minesweeper.core.MinesweeperGame;

public interface MinesweeperGameViewer {

    public void show();
    public void refresh(MinesweeperGame game);
    public void showMines();
    
}
