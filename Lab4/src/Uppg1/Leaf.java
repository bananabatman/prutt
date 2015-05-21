package Uppg1;

import java.util.ArrayList;

public class Leaf extends Component {

	private int weight;
	private String name;

	public Leaf(String name, int weight) {
		super(name, weight);
		this.name = name;
		this.weight = weight;
		// TODO Auto-generated constructor stub
	}
	public int getWeight() {
		return weight;
		//getWeight för en pryl/löv reurnerar endast prylens vikt
		//för behållaren returneras hela behållarens vikt	
	}
	
	public String toString() {
		//för pryl: returnerar namnet
		//för behållare: behållarens namn +
		//namnen på alla saker i behållaren
		return this.name+"("+this.weight+")"+" ";
	}
	
	public void add(Component c) {

	}
	public void remove(Component c) {
	}
}
