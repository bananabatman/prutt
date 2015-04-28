package Lab_1;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JApplet;
/* <applet code = "test" width = 300 height = 300> </applet> */

public class Labb1 extends JApplet {
	static MyButton button;
	static Color randomColor1;
	static Color randomColor2;
	static Random rand = new Random();
	public void init() {
		String[] args = new String[] {"2", "test1"," test2", "test3","test4"};
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		String[] buttonText = Arrays.copyOfRange(args, 1,Integer.valueOf(args[0])*2+1);
		ArrayList<MyButton> buttons = new ArrayList<MyButton>();
		for(int i=0; i<Integer.valueOf(args[0])*2; i=i+2){
			randomColor1 = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
			randomColor2 = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
			button = new MyButton(randomColor1, randomColor2, buttonText[i], buttonText[i+1]);
			cp.add(button);		
			buttons.add(button);
		}
		cp.setVisible(true);
		Window dispWindow = new Window(buttons);

	}

}
