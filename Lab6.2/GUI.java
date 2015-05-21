package Web;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Currency;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.*;
import javax.swing.text.*;

public class GUI {
    static String[][] linkMatrix;
    WebReader ep;
    static String currentURL;

    public GUI() {
        final JFrame wf = new JFrame();
        wf.setLayout(new BorderLayout());
        //Webbläsaren
        ep = new WebReader();
        //currentURL = "http://www.nada.kth.se/~henrik/";
        wf.add(ep, BorderLayout.CENTER);
        //Textfält innehåller webadress
        final JTextField tf = new JTextField();
        tf.setText("http://");
        wf.add(tf, BorderLayout.NORTH);
        HyperlinkListener listener = new HyperlinkListener() {

            @Override

            public void hyperlinkUpdate(HyperlinkEvent event) {
                if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    try {
                        ep.setPage(event.getURL());
                        tf.setText(event.getURL().toString());
                        tf.postActionEvent();
                    } catch (IOException ioe) {
                        System.err.println("TOKIGT VID URL: " + ioe);
                    }
                }
            }

        };

        ep.addHyperlinkListener(listener);
        final JTable table = new JTable(50, 2);
        final JScrollPane links = new JScrollPane(table);
        links.setVisible(false);
        wf.add(links, BorderLayout.EAST);
        final String[] headers = new String[]{"A-Tag", "HREF"};
        table.setBackground(new Color(255, 20, 147));
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GUI.setURL(tf.getText());
                    links.setVisible(true);
                    ep.showPage(GUI.getURL());
                    LinkTable newLink = new LinkTable(GUI.getURL());
                    GUI.setLinkMatrix(newLink.getMatrix());
                    table.setModel(new DefaultTableModel(getLinkMatrix(), headers));

                    //Vid tryck på enter efter korrekt url i fältet visas hemsidan
                } catch (IOException e1) {
                    //Make popup
                    JOptionPane error = new JOptionPane();
                    error.showMessageDialog(wf, "FEL"); //Varför klagar den?
                }
            }
        });
        //Tabell som innehåller länkar, ska ej kunna skrivas i

        wf.setPreferredSize(new Dimension(800, 800));
        wf.pack();
        wf.setVisible(true);
    }

    public static void main(String[] args) {
        GUI tempG = new GUI();
        System.out.println(GUI.getURL() + " ");
    }

    public static void setURL(String inUrl) {
        //System.out.println(inUrl + " " + currentURL + " pre");
        currentURL = inUrl;
        //System.out.println(inUrl + " " + currentURL + " post");
    }

    public static void setLinkMatrix(String[][] inMatrix) {
        linkMatrix = inMatrix;
    }

    public static String getURL() {
        return currentURL;
    }

    public static String[][] getLinkMatrix() {
        return linkMatrix;
    }
}
