package minesweeper.core.tool;

import minesweeper.core.MinesweeperCell;


public class MinesweeperNumberPutter {

    public static MinesweeperCell[][] putNumbers(MinesweeperCell[][] inTable){
        MinesweeperCell[][] numberedTable = inTable;
        for (int i = 0; i < numberedTable.length; i++)
            for (int j = 0; j < numberedTable[i].length; j++)
                numberedTable[i][j].setValue(writeNumberOfAdjacentMines(inTable,i,j));
        return numberedTable;
    }

    private static char writeNumberOfAdjacentMines(MinesweeperCell[][] inTable, int y, int x) {
        if(inTable[y][x].getValue()=='#')
            return numberOfAdjacentMines(inTable,y,x);
        return inTable[y][x].getValue();
    }

    private static char numberOfAdjacentMines(MinesweeperCell[][] inTable, int y, int x) {
        int[] topLeftAreaCorner = {y-1,x-1};
        int[] bottomRightAreaCorner = {y+1,x+1};
        topLeftAreaCorner = getAdjustedAreaCorner(topLeftAreaCorner, inTable);
        bottomRightAreaCorner = getAdjustedAreaCorner(bottomRightAreaCorner, inTable);
        int mineCount = 0;
        for (int i = topLeftAreaCorner[0]; i <= bottomRightAreaCorner[0]; i++)
            for (int j = topLeftAreaCorner[1]; j <= bottomRightAreaCorner[1]; j++)
                    if(inTable[i][j].getValue()=='M')mineCount++;
        char cellValue = (char) ('0'+mineCount);
        if(mineCount == 0) cellValue = '#';
        return cellValue;
    }


    private static int[] getAdjustedAreaCorner(int[] areaCorner, MinesweeperCell[][] inTable) {
        if(areaCorner[0]<0)
              areaCorner[0]=0;         
        if(areaCorner[1]<0)
              areaCorner[1]=0;
        if(areaCorner[1]>=inTable[0].length)
            areaCorner[1]=inTable[0].length-1;
        if(areaCorner[0]>=inTable.length)
            areaCorner[0]=inTable.length-1;
        return areaCorner;
    }
    
}
