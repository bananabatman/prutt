package Lab_1;

import java.awt.Color;
<<<<<<< HEAD
import java.awt.Component;
=======
>>>>>>> cbf0f3aa9a33e48b8727270e84295848b90c903b
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

<<<<<<< HEAD
import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
=======
import javax.swing.JApplet;
/* <applet code = "test" width = 300 height = 300> </applet> */
>>>>>>> cbf0f3aa9a33e48b8727270e84295848b90c903b

public class Labb1 extends JApplet {
	static MyButton button;
	static Color randomColor1;
	static Color randomColor2;
	static Random rand = new Random();
	public void init() {
<<<<<<< HEAD
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		String[] args = new String[] {"2", "ett", "två", "tre", "fyra"};
=======
		String[] args = new String[] {"2", "test1"," test2", "test3","test4"};
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
>>>>>>> cbf0f3aa9a33e48b8727270e84295848b90c903b
		String[] buttonText = Arrays.copyOfRange(args, 1,Integer.valueOf(args[0])*2+1);
		ArrayList<MyButton> buttons = new ArrayList<MyButton>();
		for(int i=0; i<Integer.valueOf(args[0])*2; i=i+2){
			randomColor1 = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
			randomColor2 = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
			button = new MyButton(randomColor1, randomColor2, buttonText[i], buttonText[i+1]);
			cp.add(button);		
			buttons.add(button);
			c.add(button);
		}
<<<<<<< HEAD
		//Window dispWindow = new Window(buttons);
	

=======
		cp.setVisible(true);
		Window dispWindow = new Window(buttons);
>>>>>>> cbf0f3aa9a33e48b8727270e84295848b90c903b

	}

}
