package minesweeper.core.tool;
import java.util.Random;
import minesweeper.core.MinesweeperCell;

public class MinesweeperMinePutter {
    
    public static MinesweeperCell[][] putMines(MinesweeperCell[][] table,int numberOfMines){
        int tablesSize = table.length*table[0].length;
        int[] sortedFlatTable,randomFlatTable;
        sortedFlatTable = new int[tablesSize];
        
        for (int i = 0; i < tablesSize; i++) sortedFlatTable[i]=i;
        randomFlatTable = shuffleArray(sortedFlatTable);
        
        table = popMines(table, randomFlatTable, numberOfMines); //cuidadin
        return table;
    }
    
    private static MinesweeperCell[][] popMines(MinesweeperCell[][] table, int[] randomFlatTable,int max){
        int pos,col,row;
        for (int i = 0; i < max; i++) {
            pos = randomFlatTable[i];
            col = pos%table[0].length;
            row = pos/table[0].length;
            table[row][col].setValue('M');
        }
        return table;        
    } 
    
    private static int[] shuffleArray(int[] ar){
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }
}
