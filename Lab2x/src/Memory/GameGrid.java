package Memory;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;


public class GameGrid extends JFrame{

    private static JPanel buttons;

	public GameGrid(Square[][] squareList){
        buttons = new JPanel();
        this.makeGrid(squareList);
        buttons.setLayout(new GridLayout(squareList.length,squareList[0].length));
	}

    public void makeGrid (Square[][] squareList) {
        for(int i=0;i<squareList.length;i++){
            for(int j=0;j<squareList[0].length;j++){
                buttons.add(squareList[i][j]);
            }
        }this.add(buttons);
    }
    public void update(Square[][] squareList) {
        buttons.removeAll();
        makeGrid(squareList);
        buttons.revalidate();
    }

}

//TODO: Make this return a full set of Square[][] after button-creation
