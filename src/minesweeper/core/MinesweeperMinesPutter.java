package minesweeper.core;
import java.util.Random;

public class MinesweeperMinesPutter {
    
    public static char[][] putMines(char[][] table,int numberOfMines){
        int tablesSize = table.length*table[0].length;
        int[] sortedFlatTable,randomFlatTable;
        sortedFlatTable = new int[tablesSize];
        
        for (int i = 0; i < tablesSize; i++) sortedFlatTable[i]=i;
        randomFlatTable = shuffleArray(sortedFlatTable);
        System.out.println("randomFlatTable.lenght"+randomFlatTable.length);
        System.out.println("randomFlatTable.lenght"+sortedFlatTable.length);
        
        table = popMines(table, randomFlatTable, numberOfMines); //cuidadin
        return table;
    }
    
    private static char[][] popMines(char[][] table, int[] randomFlatTable,int max){
        int pos,col,row;
        for (int i = 0; i < max; i++) {
            pos = randomFlatTable[i];
            col = pos%table[0].length;
            row = pos/table[0].length;
            System.out.println("pos "+pos+" "+"col"+col+" "+"row"+row);
            table[row][col] = 'M';
        }
        return table;        
    } 
    
     // Implementing Fisher–Yates shuffle #PASTE de Google
    private static int[] shuffleArray(int[] ar){
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }
}
