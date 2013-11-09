package minesweeper.core;

public class MinesweeperCell {

    private char value;
    private boolean visibility;

    public MinesweeperCell(char value, boolean visibility) {
        this.value = value;
        this.visibility = visibility;
    }
    public MinesweeperCell(char value) {
        this(value,false);
    }
    public MinesweeperCell() {
        this('#');
    }
    public MinesweeperCell(MinesweeperCell cell) {
        this.value = cell.getValue();
        this.visibility = cell.getVisibility();
    }
    
    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
