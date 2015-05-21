package Tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class PrepTreeX extends TreeFrame {
	static Queue<String >textQueue;
	void initTree() {
		textQueue= makeQueue();
		MyNode parent = makeNode(textQueue.poll());
		MyNode root = buildNodes(parent);

		Enumeration e = root.preorderEnumeration();
		treeModel = new DefaultTreeModel( root );
		tree = new JTree( treeModel );
	}

	private Queue<String> makeQueue(){
		Queue<String> textQueue = new LinkedList<String>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("Liv.txt"));
			String newLine = "";
			while((newLine=br.readLine())!=null){ //Reads and stores newLine until EOF
				textQueue.add(newLine.substring(1));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textQueue.poll(); //Removes encoding-tips
		return textQueue;
	}

	private MyNode buildNodes(MyNode inNode) {

		while(!textQueue.isEmpty()){ 
			if(textQueue.peek().substring(0,1).equals("/")){ //Om det inte finns n√•got barn till den h√§r parenten
				if(textQueue.peek().trim().substring(1,textQueue.peek().trim().length()-1).equals(inNode.level)){
					textQueue.poll();
					return inNode;
				}
			} else {
				MyNode newChild = makeNode(textQueue.poll());
				inNode.add(buildNodes(newChild));
			}
		}
		return inNode;
	}

	void showDetails(TreePath p){
		if ( p == null )
		    return;
		MyNode clickedNode = ((MyNode) p.getLastPathComponent());
		int lvl = clickedNode.getLevel();
		String firstname = clickedNode.getName();
		String orig =  clickedNode.getLevelName()+": "+clickedNode.getName() + 
				" " +clickedNode.getDescription();
				
		String extra = " men allt som ‰r " + firstname;
		for(int i=0; i<lvl;i++) {
			MyNode nodeBefore = (MyNode) clickedNode.getParent();
			extra+= " ‰r "+ nodeBefore;
			clickedNode = nodeBefore;
			
		}
		
		JOptionPane.showMessageDialog( this, orig + extra);
		}

	private MyNode makeNode(String inString){
		String[] result = inString.split("\"");
		String level = result[0].split(" ")[0];
		String name = result[1];
		String desc = result[2].substring(2);
		MyNode newNode = new MyNode(name, level, desc);
		return newNode;

	}

	public static void main(String[] args) {
		new PrepTreeX();
	}
}
