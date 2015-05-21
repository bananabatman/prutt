package ExtraUppg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import Uppg1.Component;
import Uppg1.Composite;

public class Djupet implements Iterator {
	//Behöver en stack
	private Stack<Component> bStack;
	private ArrayList<Component> inList;
	private Stack<Component> bfs_s;
	private Component parent;
	//Ha koll på hur långt man gått med next

	public Djupet(Component c) {
		System.out.println("start");
		bStack = new Stack<Component>();
		bStack.push(c);
		bfs_s = new Stack<Component>();
		fill();
		/*while(!bStack.isEmpty()){
			System.out.println(bStack.pop());
		}
		bfs_s = fill(parent);*/
	}

	//Låt Composite implementera Iterable så att den har metoden iterator()
	//Definiera iterator() så att den returnerar ett iterator objekt
	//gå igenom composite med for each sats såväl som iteratorns metoder

	//Besök först roten, därefter rotens alla barn, sen rotens barnbarn osv.

	public boolean hasNext() {
		//Använd peek och titta om det fungerar
		// returnera true om det finns fler element att besöka

		if(bfs_s.isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}

	private void fill () {
		
		while(!bStack.isEmpty()) {
			Component toPop = bStack.pop();
			if(toPop.getClass().equals(Uppg1.Composite.class)) {
				Composite tempComp = ((Composite) toPop);
				for(int i=tempComp.compList.size()-1; i>=0;i--){
					if(tempComp.compList.get(i).getClass().equals(Uppg1.Composite.class)) {
						
						bStack.push(tempComp.compList.get(i));
						fill();
					} else{
						bfs_s.push(tempComp.compList.get(i));
					}
				}
				bfs_s.push(toPop);
			}
		}
	}


	// Object.getClass(); för att kolla om löv eller träd
	// gå fram ett steg enligt bredden först 
	// och stoppa element i kön


	public Component next() {
		//element fungerar som peek men throws exception
		//om nästa element är null
		if(hasNext()){
			return bfs_s.pop();

		}else{
			return null;
		}

	}

	public void remove() {
		//NEJ
		// krävs ej i labben, implementeras tom
	}

}
