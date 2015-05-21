package Uppg1;

import java.util.ArrayList;
import java.util.Iterator;

import ExtraUppg.Bredden;
import ExtraUppg.Djupet;

public class Composite extends Component implements Iterable  {
	private int weight;
	private String name;
	//compList är "trädet", innehåller bags and stuff
	public ArrayList<Component> compList;
	public Composite(String name, int weight) {
		super(name, weight);
		this.name = name;
		this.weight = weight;
		compList = new ArrayList<Component>();
		// TODO Auto-generated constructor stub
	}

	//ÄR TRÄDET
	//ÄR BEHÅLLARE

	//Objekt ordnande hierarkiskt i trädstruktur ska
	//kunna behandlas som ett enstaka objekt
	//a.k.a ett metodanrop på på det sammansatta objektet
	//ska utföras på alla objektets delar (trädet)
	//samma anrop på ett löv påverkar endast lövet


	//Krävs minst 3 nivåer av sammansättning
	//Ex: hårspännen kan ligga i en påse som ligger 
	//i en necessär tillsammans med tvål och 
	//necessären 
	//Behållare i form av resväska, necessär, påse

	@Override
	public void add(Component c) {
		compList.add(c);

	}
	@Override
	public void remove(Component c) {
		compList.remove(c);
	}
	
	public int getWeight() {
		int totWeight = 0;
		for(int i=0;i<compList.size();i++){
			totWeight += compList.get(i).getWeight();
		}
		return totWeight+this.weight;
		//getWeight för en pryl/löv reurnerar endast prylens vikt
		//för behållaren returneras hela behållarens vikt	
	}
	
	@Override
	public String toString() {
		String totName = " ";
		//för pryl: returnerar namnet
		//för behållare: behållarens namn +
		//namnen på alla saker i behållaren
		for(int i=0;i<compList.size();i++){
			totName += compList.get(i).toString()+" ";
		}
		return this.name+": ("+this.weight+")"+" [composite] "+totName;
	}

	@Override
	public Iterator<Component> iterator() {
		//Returnera en bredden iterator eller en djupet
		//Bredden iterator = new Bredden(this.compList);
		Djupet iterator = new Djupet(this);
		return iterator;
	}

}
