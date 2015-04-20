package Lab_1;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JApplet;

public class Labb1 extends JApplet {
	static MyButton button;
	static Color randomColor1;
	static Color randomColor2;
	static Random rand = new Random();
	public static void main(String[] args) {
		String[] buttonText = Arrays.copyOfRange(args, 1,Integer.valueOf(args[0])*2+1);
		ArrayList<MyButton> buttons = new ArrayList<MyButton>();
		for(int i=0; i<Integer.valueOf(args[0])*2; i=i+2){
			randomColor1 = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
			randomColor2 = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
			button = new MyButton(randomColor1, randomColor2, buttonText[i], buttonText[i+1]);
			buttons.add(button);
		}
		Window dispWindow = new Window(buttons);

	}

}
