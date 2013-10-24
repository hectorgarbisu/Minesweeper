package minesweeper.core;


public class MinesweeperUnhideTool {

  
    public MinesweeperUnhideTool() {
    }
    
    public static int[][] getExtendedUnhidePattern(char[][] table,int[] position){
        int[][] pattern = new int[table[0].length][table.length];
        pattern = getExtendedPattern(pattern,table,position[0],position[1]);
        return pattern;
    }    
    
    private static int[][] getExtendedPattern(int[][] pattern, char [][] table, int x, int y) {
        int[][] decPattern = pattern;
        if(Character.isDigit(table[x][y])
        ||(table[x][y]==' '))
            decPattern = addPosition(decPattern,x,y);
        
        if(canGoLeft(table,x)){
        if(Character.isDigit(table[x-1][y])
        ||(table[x-1][y]==' '))
            decPattern = getExtendedPattern(decPattern, table, x-1,y);
        }
        
        if(canGoRight(table,x)){
        if(Character.isDigit(table[x+1][y])
        ||(table[x+1][y]==' '))
            decPattern = getExtendedPattern(decPattern, table, x+1,y);
        }
        
        if(canGoUp(table,y)){
        if(Character.isDigit(table[x][y-1])
        ||(table[x][y-1]==' '))
            decPattern = getExtendedPattern(decPattern, table, x,y-1);
        }
        
        if(canGoDown(table,y)){
        if(Character.isDigit(table[x][y+1])
        ||(table[x][y+1]==' '))
            decPattern = getExtendedPattern(decPattern, table, x,y+1);
        }
        
        return decPattern;
    }
        private static boolean canGoLeft(char[][] table, int x){
            return x>-1;
        }
        private static boolean canGoRight(char[][] table, int x){
            return x<table[0].length;
        }
        private static boolean canGoUp(char[][] table, int y){
            return y>-1;
        }
        private static boolean canGoDown(char[][] table, int y){
            return y<table.length;
        }
        
        private static int[][] addPosition(int[][] pattern,int x, int y) {
            int[] pair = new int[]{x,y};
            for (int i = 0; i < pattern[0].length; i++) {
                if(pattern[i]==null)
                    pattern[i] = pair;
                if(pattern[i]==pair)
                    return pattern;
            }
            return pattern;
        }
   
        
}
