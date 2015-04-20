package lab_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private int size;
    private Square[][] board;        // Square är subklass till JButton
    private JLabel mess = new JLabel();
    ViewControl (Boardgame gm, int n){  // OK med fler parametrar om ni vill!
    	GameGrid grid = new GameGrid(n);
    	grid.pack();
    	grid.setVisible(true);
    	
    }
    public boolean makeButtons(Boardgame game){
    	
    	return true;
    }
    
    public static void main(String[] args){
    	ViewControl view = new ViewControl(null, Integer.valueOf(args[0]));
    }
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
//for i,j -> read text -> create button -> put button in board-array
/*
TODO: Add action listener functionality
TODO: Connect to boardgame
TODO: Store buttons in board-grid
*/