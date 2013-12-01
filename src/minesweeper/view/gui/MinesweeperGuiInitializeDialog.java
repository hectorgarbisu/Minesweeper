package minesweeper.view.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.MaskFormatter;
import minesweeper.view.MinesweeperInitializeDialog;

public class MinesweeperGuiInitializeDialog extends JFrame implements MinesweeperInitializeDialog {

    private int x;
    private int y;
    private int numberOfMines;
    private JFormattedTextField widthField;
    private JFormattedTextField heightField;
    private JFormattedTextField minesField;
    private JButton okButton;
    private JButton resetButton;

    public MinesweeperGuiInitializeDialog() {
        this.setTitle("Please, type game parameters");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(400, 400));
        this.setMinimumSize(new Dimension(400, 400));
        this.setVisible(true);
        this.setLayout(new GridLayout(3, 3));
        this.add(new JLabel("Width"));
        this.add(createWidthField());
        this.add(new JLabel("Height"));
        this.add(createHeightField());
        this.add(new JLabel("Mines"));
        this.add(createMinesField());
    }

    @Override
    public void execute() {
    }

    @Override
    public int[] getValues() {
        return new int[]{this.x, this.y, this.numberOfMines};
    }
    
    private void setGameValues() {
        x = Integer.parseInt(widthField.getText());
        y = Integer.parseInt(heightField.getText());
        numberOfMines = Integer.parseInt(minesField.getText());
    }


    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getNumberOfMines() {
        return numberOfMines;
    }

    private JTextField createWidthField() {
        widthField = new JFormattedTextField(createFormatter("##"));
        widthField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    setGameValues();
                }
            }
        });
        return widthField;
    }

    private JTextField createHeightField() {
        heightField = new JFormattedTextField(createFormatter("##"));
        heightField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    setGameValues();
                }
            }
        });
        return heightField;
    }

    private JTextField createMinesField() {
        minesField = new JFormattedTextField(createFormatter("###"));
        minesField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    setGameValues();
                }
            }
        });
        return minesField;
    }

    private MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }
}
