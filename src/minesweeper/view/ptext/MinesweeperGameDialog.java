package minesweeper.view.ptext;

import minesweeper.core.*;
import minesweeper.core.support.*;

public class MinesweeperGameDialog {

    private XYLocation position;
    private boolean actionIsToFlag;

    public XYLocation getPosition() {
        return position;
    }

    public boolean actionIsToFlag(){
        return actionIsToFlag;
    }
    
    public void MinesweeperGameDialog() {
    }
    

    public void askAction() {
        position = new XYLocation();
        ActionReader actionReader = new ActionReader();
        System.out.println("Indique la acción y la posición que quiere jugar");
        System.out.println("Formato: \"[+|-] %fila %columna\" (+para clicar y - para poner bandera, la accion por defecto es clicar) ");
        actionReader.askAction();
        position = actionReader.getPosition();
        actionIsToFlag = actionReader.actionIsToFlag();
        //position = NumberFromIO.pairFromIO();
    }
}
