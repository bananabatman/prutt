package ExtraUppg;
import Uppg1.Composite;
import java.util.*;

import Uppg1.Component;

public class Bredden implements Iterator {
	//Behöver en kö
	private Queue<Component> bQueue;
	private ArrayList<Component> inList;
	private Queue<Component> bfs_q;
	private Component parent;
	//Ha koll på hur långt man gått med next

	public Bredden(ArrayList<Component> inList) {
		System.out.println("start");
		bQueue = new LinkedList<Component>();
		this.inList=inList;
		bQueue.addAll(this.inList);
		bfs_q = fill(parent);
	}

	//Låt Composite implementera Iterable så att den har metoden iterator()
	//Definiera iterator() så att den returnerar ett iterator objekt
	//gå igenom composite med for each sats såväl som iteratorns metoder

	//Besök först roten, därefter rotens alla barn, sen rotens barnbarn osv.
	
	public boolean hasNext() {
		//Använd peek och titta om det fungerar
		// returnera true om det finns fler element att besöka
		
		if(bfs_q.isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}
	
	private Queue<Component> fill (Component parent) {
		Queue<Component> output = new LinkedList<Component>();
		while(!bQueue.isEmpty()) {
			if(bQueue.peek().getClass().equals(Uppg1.Composite.class)) {
				parent = bQueue.poll();
				output.add(parent);
				Composite compP = (Composite) parent;
				bQueue.addAll(compP.compList);
				if(bQueue.peek().getClass().equals(Uppg1.Leaf.class)) {
					output.add(bQueue.poll());
				} else {
					parent = bQueue.poll();
					fill(parent);
				}
			}
			else{
				output.add(bQueue.poll());
			}
		}
		
		// Object.getClass(); för att kolla om löv eller träd
		// gå fram ett steg enligt bredden först 
		// och stoppa element i kön
		return output;
	}

	public Component next() {
		//element fungerar som peek men throws exception
		//om nästa element är null
		if(hasNext()){
			return bfs_q.poll();
		}else{
			return null;
		}
		
	}

	public void remove() {
		//NEJ
		// krävs ej i labben, implementeras tom
	}

}
