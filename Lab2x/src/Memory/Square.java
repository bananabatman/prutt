package Memory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Square extends JButton {
    int xVal;
    int yVal;
    public Square(String value, int inX, int inY) { //, ActionListener e
        this.xVal = inX;
        this.yVal = inY;
        this.setPreferredSize(new Dimension(50,50));
        this.setText(value);
        this.setForeground(Color.black);
    }
    public void setLabelText(String inText){
        this.setText(inText);
    }

    public String toString(){
        return this.getText();
    }

}
