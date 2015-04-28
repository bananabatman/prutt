package lab_2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Square extends JButton {
	int xVal;
    int yVal;
    String buttonText;
	public Square(String value, int inX, int inY) { //, ActionListener e
		JButton square = new JButton();
        buttonText = value;
        this.xVal = inX;
        this.yVal = inY;
		this.setPreferredSize(new Dimension(50,50));
		this.setText(buttonText);
		this.setForeground(Color.black);
        //System.out.println("x: "+xVal+" y: "+yVal+" knapptext:"+value);
	}


       public ArrayList<Integer> getCoordinates() {
           ArrayList coordinates = new ArrayList();
           coordinates.add(this.xVal);
           coordinates.add(this.yVal);
           return coordinates;
       }
}
