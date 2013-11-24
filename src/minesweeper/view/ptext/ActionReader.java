package minesweeper.view.ptext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import minesweeper.core.support.XYLocation;

class ActionReader {

    private boolean actionIsToFlag;
    private XYLocation position;

    public ActionReader() {
        position = new XYLocation();
    }

    public boolean actionIsToFlag() {
        return actionIsToFlag;
    }

    public XYLocation getPosition() {
        return position;
    }

    public void askAction() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Y = 0;
        String input = "";
        try {
            input = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ActionReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        actionIsToFlag = (input.indexOf("-") == 0);
        Y = (Integer.parseInt((input.split(" "))[0]));
        if (Y<0) Y *= -1;
        position.setY(Y);
        position.setX(Integer.parseInt((input.split(" "))[1]));


    }

    private void mensajeError(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
