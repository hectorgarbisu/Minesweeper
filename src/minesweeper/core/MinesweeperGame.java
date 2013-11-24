package minesweeper.core;

import minesweeper.core.support.XYLocation;

public class MinesweeperGame {
        private MinesweeperState state;
        private boolean isFinal;
        private boolean victory;

    public MinesweeperGame(MinesweeperState state) {
        this.state = state;
        this.isFinal = false;
    }
    public MinesweeperGame(int[] initialValuesArray){
        this(new MinesweeperState(initialValuesArray));
    }
    public MinesweeperGame() {
        this(new MinesweeperState());
    }

    public MinesweeperState getState() {
        return state;
    }


    public void makeMove(XYLocation position) {
        state.makeMove(position);
    }
    
    public void flagPosition(XYLocation position) {
        state.flagPosition(position);
    }
    
    public boolean isTerminal(){
        boolean userCanMakeMoves = false;
        MinesweeperCell[][] table = state.getTable();
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[i].length; j++){
                if(table[i][j].getValue() == 'D') {
                    victory = false;
                    return true;
                }                
                if(!(table[i][j].isVisible())&&!(table[i][j].getValue()=='M')) userCanMakeMoves = true;
            }
        victory = true;
        return !userCanMakeMoves;
    }
    public boolean hasWon(){
        return victory;
    }

}
