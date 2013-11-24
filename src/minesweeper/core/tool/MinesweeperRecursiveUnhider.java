package minesweeper.core.tool;

import minesweeper.core.MinesweeperCell;
import minesweeper.core.support.XYLocation;


public class MinesweeperRecursiveUnhider {
    private static XYLocation[] shownLocations;
    private static MinesweeperCell[][] stateTable;


    public static XYLocation[] getUnhidenLocations() {
        return shownLocations;
    }
    public static int getUnhidenLocationsSize(){
        return shownLocations.length;
    }
   
    public static MinesweeperCell[][] doRecursiveUnhiding(MinesweeperCell[][] table, XYLocation startHere){
        stateTable = table;
        shownLocations = new XYLocation[table.length*table[0].length];
        doRecursiveMagic(startHere);
        return stateTable;
    }
    
    private static void doRecursiveMagic(XYLocation here){
        if(!isListed(here))addShownLocation(here);
        tryLeft(here);
        tryRight(here);
        tryUp(here);
        tryDown(here);
                
    }
    private static void tryLeft(XYLocation here){
        if(hasLeft(here)){
                if(!isListed(here.left())
                &&isListable(here,here.left()))
                doRecursiveMagic(here.left());
        }
    }
    private static void tryRight(XYLocation here){
        if(hasRight(here)){
                if(!(isListed(here.right()))&&
                isListable(here,here.right()))            
                doRecursiveMagic(here.right());
        }
    }
    private static void tryUp(XYLocation here){
        if(hasUp(here)){
                if(!isListed(here.up())
                &&isListable(here,here.up()))
                doRecursiveMagic(here.up());
        }
    }
    private static void tryDown(XYLocation here){
        if(hasDown(here)){
            if(!isListed(here.down())
                &&isListable(here,here.down()))
                doRecursiveMagic(here.down());
        }
    }
    private static boolean isListed(XYLocation location){
        for (XYLocation shownLocation : shownLocations) {
            if(shownLocation==null) return false;
            if(shownLocation.equals(location))return true;
        }
        return false;
    }
    private static void addShownLocation(XYLocation requestingLocation){
        for (int i = 0; i < shownLocations.length; i++) {
            if(shownLocations[i]==null){
                shownLocations[i]=requestingLocation;
                //System.out.println("he metido "+requestingLocation+" en "+i);
            }
            if(shownLocations[i].equals(requestingLocation))
                break;
        }
        stateTable[requestingLocation.getY()][requestingLocation.getX()].setVisible(true);
    }
   
    private static boolean isListable(XYLocation fromLocation, XYLocation toLocation) {
        return hasListedEmptyNeighbour(toLocation);
    }
    
    private static boolean hasListedEmptyNeighbour(XYLocation location) {
        for (XYLocation neighbouringLocation : location.getNeighbours()) {
            if(isListed(neighbouringLocation)&&
                    stateTable[neighbouringLocation.getY()][neighbouringLocation.getX()].getValue()=='#')
                return true;
        }
        return false;
    }
    public static boolean hasLeft(XYLocation position){
        return position.getX()>0;
    }
    public static boolean hasRight(XYLocation position){
        return position.getX()<stateTable[0].length-1;
    }    
    public static boolean hasUp(XYLocation position){
        return position.getY()>0;
    }
    public static boolean hasDown(XYLocation position){
        return position.getY()<stateTable.length-1;
    }


}
