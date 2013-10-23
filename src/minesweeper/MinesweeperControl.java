package minesweeper;

public class MinesweeperControl {

    public MinesweeperControl() {
    }
    
    public void execute(){
       MinesweeperDialog minesweeperDialog = new MinesweeperDialog();
       minesweeperDialog.execute();
       int width = minesweeperDialog.getX();
       int height = minesweeperDialog.getY();
       int numberOfMines = minesweeperDialog.getNumberOfMines();
       MinesweeperState minesweeperState = new MinesweeperState(width,height,numberOfMines);
       MinesweeperViewer minesweeperViewer = new MinesweeperViewer(minesweeperState);
       minesweeperViewer.show();
    }
    
}
