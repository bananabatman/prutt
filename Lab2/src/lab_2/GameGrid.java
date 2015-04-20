package lab_2;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class GameGrid extends JFrame{

	public GameGrid(int n){
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(n,n));
		for(int i=0;i<Math.pow(n, 2);i++){
			Square newButton = new Square(Integer.toString(i+1));
			this.add(newButton);
			
		}
	}
}

//TODO: Make this return a full set of Square[][] after button-creation
