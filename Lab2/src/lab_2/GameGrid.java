package lab_2;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;


public class GameGrid extends JFrame{

    private static JPanel buttons;
    private static JLabel lbl;
    Container content;
	public GameGrid(Square[][] squareList){
        lbl = new JLabel("Välkommen");

        content = this.getContentPane();
        content.setLayout(new BorderLayout());
        content.add(lbl, BorderLayout.SOUTH);
        buttons = new JPanel();
        //buttons.setOpaque(true);
        this.makeGrid(squareList);
        buttons.setLayout(new GridLayout(squareList.length,squareList[0].length));
        content.add(buttons, BorderLayout.NORTH);
        content.add(lbl);
        content.setVisible(true);
        pack();
        setVisible(true);
	}

    public void makeGrid (Square[][] squareList) {

        for(int i=0;i<squareList.length;i++){
            for(int j=0;j<squareList[0].length;j++){
                buttons.add(squareList[i][j]);
            }
        }content.add(buttons, BorderLayout.CENTER);
    }

    public void update(String message) {
        lbl.setText(message);
        buttons.revalidate();
        buttons.repaint();
    }

}

//TODO: Make this return a full set of Square[][] after button-creation
