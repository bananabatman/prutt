package Uppg1;

public abstract class Component {
	
	private String name;
	private int weight;

	public Component(String name, int weight) {
		//alla komponenter ska ha namn ochen vikt som instansvariabler
		//initieras i konstruktorn när objekt skapas
		this.name = name;
		this.weight = weight;
	}

	abstract public int getWeight();
		//getWeight för en pryl/löv reurnerar endast prylens vikt
		//för behållaren returneras hela behållarens vikt	
	
	
	abstract public String toString();
		//för pryl: returnerar namnet
		//för behållare: behållarens namn +
		//namnen på alla saker i behållaren
	
	
	abstract public void add(Component c);
	
	abstract public void remove(Component c) ;
}
