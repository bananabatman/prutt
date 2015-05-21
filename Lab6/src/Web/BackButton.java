package Web;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

/**
 * Created by tonyf_000 on 2015-05-16.
 */
public class BackButton extends JButton {
    Stack urlStack;
    public BackButton(String inName, Stack inStack){
        setText(inName);
        this.urlStack = inStack;
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(urlStack.size()<=1){
                    return;
                }
                try {
                    urlStack.pop();
                    String tempURL = (String) urlStack.peek();
                    //url.set
                } catch (Exception abc) {

                }

            }
        });
    }
}
