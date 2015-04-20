package lab_2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Square extends JButton {
	
	public Square(String value) { //, ActionListener e
		JButton square = new JButton();
		this.setPreferredSize(new Dimension(50,50));
		this.setText(value);
		this.setForeground(Color.black);
	}


}
