package Tree;

import javax.swing.tree.DefaultMutableTreeNode;

public class MyNode extends DefaultMutableTreeNode{
	String name;
	String level;
	String description;
	
	public MyNode(String name, String level, String description) {
		this.level = level;
		this.name = name;
		this.description = description;
//		this.allowsChildren = true;
	}	
	public String getLevelName(){
		return this.level;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public String toString(){
		if(this.isLeaf()){
			return name;
		}
		else{
			return name;
		}
		
	}
	
	

}
