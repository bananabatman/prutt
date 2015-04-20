package Lab_1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButton extends JButton implements ActionListener{
	Color primary;
	Color secondary;
	String primStr;
	String secStr;
	String dispStr;
	Color dispCol;

	/**
	 * @param args
	 */
	public MyButton(Color c1, Color c2, String s1, String s2){
		primary = c1;		
		secondary = c2;
		primStr = s1;
		secStr = s2;
		this.setText(s1);
		this.setBackground(c1);
		this.setForeground(Color.white);
		this.setOpaque(true);
		this.setVisible(true);
		this.addActionListener(this);
	}

	public void toggleState(){
		if((this.getText().equals(primStr))){
			this.setBackground(secondary);
			this.setText(secStr);
		}
		else {
			this.setBackground(primary);
			this.setText(primStr);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		this.toggleState();
		
	}




}
