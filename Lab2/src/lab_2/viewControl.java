package lab_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ViewControl extends JFrame implements ActionListener {

    private FifteenModel game;
    private int size;
    private Square[][] board;        // Square �r subklass till JButton
    private JLabel mess = new JLabel();
    ViewControl (FifteenModel gm, int n){  // OK med fler parametrar om ni vill!
        this.game = gm;
        board = gm.makeButtons(n);
        GameGrid grid = new GameGrid(board);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j].addActionListener(this);
            }
        }

        grid.display(board);
    	grid.pack();
    	grid.setVisible(true);
    }

    public static void main(String[] args){
        FifteenModel newMod = new FifteenModel();
        ViewControl newView = new ViewControl(newMod, Integer.valueOf(args[0]));
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        int moveX = ((Square)e.getSource()).getCoordinates().get(0);
        int moveY = ((Square)e.getSource()).getCoordinates().get(1);
        System.out.println(moveX+" <x  y> "+moveY+"   "+((Square) e.getSource()).buttonText);
        System.out.println(e.getSource());
        //kallar på move, om move returnerar true
            //Kör swap
                //swap gör get och set coordinates
            //repaint ?
            //15model getmessage
        //annars
            //fifteenmodel printar getmessage
    }
}
//for i,j -> read text -> create button -> put button in board-array
/*
TODO: Connect to boardgame
TODO: Fix move-logic for objects
TODO: Set-coordinates metod
*/