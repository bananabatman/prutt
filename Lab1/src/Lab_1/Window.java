package Lab_1;


import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;






import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener{
    private JButton button1;
    public ArrayList<MyButton> windowButtons;

	public Window (ArrayList<MyButton> buttons){
		windowButtons = buttons;
		JFrame frame = new JFrame("PRUTT");
		frame.setVisible(true);
		frame.setSize(200,200);
		JLabel label = new JLabel("ELLA SYK -- FREDRIK HILDING", JLabel.CENTER);
		Color textCol = new Color(255,255,255);
		label.setForeground(textCol);
		frame.add(label);
		Color newCol = new Color(0, 51, 0);
		frame.getContentPane().setBackground(newCol);
		frame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.yellow, 10));
		JPanel panel = new JPanel();
		for(int i=0; i<buttons.size(); i++ ){
			buttons.get(i).addActionListener(this);
			panel.add(buttons.get(i));
		}
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setDefaultCloseOperation stänger rutan SAMT gör att programmet slutar köras
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<windowButtons.size(); i++) {
			if(e.getSource() != windowButtons.get(i)){
				System.out.println("test"+"  "+i);
				windowButtons.get(i).toggleState();
			} else{
				windowButtons.get(i).actionPerformed(null);
			}
		}
		
	}

}
