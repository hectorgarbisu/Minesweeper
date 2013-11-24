package minesweeper.core;

public class MinesweeperCell {

    private char value;
    private boolean visible;
    private boolean flagged;

    public MinesweeperCell(char value, boolean visibility, boolean flag) {
        this.value = value;
        this.visible = visibility;
        this.flagged = flag;
    }

    public MinesweeperCell(char value) {
        this(value, false, false);
    }

    public MinesweeperCell() {
        this('#');
    }

    public MinesweeperCell(MinesweeperCell cell) {
        this.value = cell.getValue();
        this.visible = cell.isVisible();
        this.flagged = cell.isFlagged();
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visibility) {
        this.visible = visibility;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }
}
