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
	String[][] linkMatrix;
	WebReader ep;
	static String currentURL;
	public GUI() {
		final JFrame wf = new JFrame();
		wf.setLayout(new BorderLayout());
		//Webbläsaren
		ep = new WebReader();
		wf.add(ep, BorderLayout.CENTER);
		//Textfält innehåller webadress
		final JTextField tf = new JTextField();
		tf.setText("http://");
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					GUI.setURL(tf.getText());
					ep.showPage(GUI.getURL());
					
					//Vid tryck på enter efter korrekt url i fältet visas hemsidan
				} catch (Exception e1) {
					//Make popup
					JOptionPane error = new JOptionPane();
					JOptionPane.showMessageDialog(wf, "FEL"); //Varför klagar den?
				}
			}
		});
		wf.add(tf, BorderLayout.NORTH);
		//Tabell som innehåller länkar, ska ej kunna skrivas i
		String[] headers = new String[]{"A-Tag", "HREF"};
		JTable table = new JTable(50,2);
		table.setModel(new DefaultTableModel(null, headers));
		table.setBackground(new Color(255,20,147));
		JScrollPane links = new JScrollPane(table);
		wf.add(links, BorderLayout.EAST);
		wf.setPreferredSize(new Dimension(800,800));
		wf.pack();
		wf.setVisible(true);
		
	}


	public static void main(String[] args) {
		GUI tempG = new GUI();
		System.out.println(GUI.getURL()+" ");
		
	}
	
	public static void setURL(String inUrl){
		currentURL = inUrl;
	}
	
	public static String getURL(){
		return currentURL;
	}

}
