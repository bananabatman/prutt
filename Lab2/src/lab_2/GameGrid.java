package lab_2;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;


public class GameGrid extends JFrame{

	public GameGrid(Square[][] squareList){
		Container pane = getContentPane();

		pane.setLayout(new GridLayout(squareList.length,squareList[0].length));
		for(int i=0;i<squareList.length;i++){
            for(int j=0;j<squareList[0].length;j++){
                this.add(squareList[i][j]);
            }

        } //Kanske göra knapparna till paneler?
	}

    public void display(Square[][] squareList) {

    }
    //Display metod
}

//TODO: Make this return a full set of Square[][] after button-creation
