package Memory;

import jdk.nashorn.internal.codegen.MethodEmitter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewControl implements ActionListener {
    public MemoryGame game;
    public GameGrid grid;
    private Square[][] board;        // Square �r subklass till JButton
    ViewControl (MemoryGame gm, int n){  // OK med fler parametrar om ni vill!
        this.game = gm;
        board = makeButtons(n);
        grid = new GameGrid(board);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j].addActionListener(this);
            }
        }
        grid.pack();
        grid.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = ((Square)e.getSource()).xVal;
        int j = ((Square)e.getSource()).yVal;
        if(game.move(i, j)){
            reLabelButtons();
            grid.update(board);
            System.out.println(game.getMessage());
        } else {
            System.out.println(game.getMessage());
        }
    }

    public void reLabelButtons() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j].setLabelText(game.getStatus(i,j));
            }
        }
    }

    private void boardPrinter(){
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++)
                System.out.print("  " + board[i][j].toString()); // getStatus
            System.out.println();
        }
    }

    public Square[][] makeButtons(int n){
        Square[][] squareField = new Square[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!(Integer.valueOf(i).equals(3) && Integer.valueOf(j).equals(3))){
                    squareField[i][j] = new Square(game.getStatus(i,j),i,j);
                } else{
                    squareField[i][j] = new Square(game.getStatus(i,j), i, j);
                }
            }
        }
        return squareField;
    }
}