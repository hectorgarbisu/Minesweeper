package minesweeper.core.tool;

import minesweeper.core.MinesweeperState;
import minesweeper.core.support.XYLocation;


public class MinesweeperRecursiveUnhider {
    XYLocation[] showedLocations;
    char[][] stateTable;

    public XYLocation[] getUnhidenLocations() {
        return showedLocations;
    }

    public MinesweeperRecursiveUnhider(XYLocation[] showedLocations) {
        this.showedLocations = showedLocations;
    }

    public MinesweeperRecursiveUnhider(MinesweeperState state) {
        this.showedLocations = new XYLocation[state.getWidth()*state.getHeight()];
        this.stateTable = state.getTable();
    }
    
    public void doRecursiveUnhiding(XYLocation startHere){
        doRecursiveMagic(startHere);
    }
    
    private void doRecursiveMagic(XYLocation here){
        if(!isListed(here))addShowedLocation(here);
        tryLeft(here);
        tryRight(here);
        tryUp(here);
        tryDown(here);
                
    }
    private void tryLeft(XYLocation here){
        if(here.hasLeft()
                &&!isListed(here.left())
                &&isListable(here,here.left()))
            doRecursiveMagic(here.left());
    }
    private void tryRight(XYLocation here){
        System.out.println("---1---");
        if(here.hasRight()&&
                !(isListed(here.right()))&&
                isListable(here,here.right()))
            doRecursiveMagic(here.right());
            System.out.println("---2---");
    }
    private void tryUp(XYLocation here){
        if(here.hasUp()
                &&!isListed(here.up())
                &&isListable(here,here.up()))
            doRecursiveMagic(here.up());
    }
    private void tryDown(XYLocation here){
        if(here.hasDown()
                &&!isListed(here.down())
                &&isListable(here,here.down()))
            doRecursiveMagic(here.down());
    }
    private boolean isListed(XYLocation location){
        
        System.out.println("---3---");
        for (int i = 0; i < showedLocations.length; i++) {
            if(showedLocations[i]==null)return false;
            if(showedLocations[i]==location)return true;
        }
        return false;
    }
    private void addShowedLocation(XYLocation requestingLocation){
        for (int i = 0; i < showedLocations.length; i++) {
            if(showedLocations[i]==null)
                showedLocations[i]=requestingLocation;
            if(showedLocations[i]==requestingLocation)
                break;
        }
        System.out.println("---4---"+requestingLocation);
    }

    private boolean isListable(XYLocation fromLocation, XYLocation toLocation) {
        if(stateTable[fromLocation.getY()][fromLocation.getX()]==' '){
            if(!(stateTable[toLocation.getY()][toLocation.getX()]=='M')){
                System.out.println(toLocation+" es listable");
                return true;
            }
        }
        return false;
    }

}
