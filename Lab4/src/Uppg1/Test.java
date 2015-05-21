package Uppg1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Test {

	//OBS TÄNK REEKURSIVT
	public static void main (String[] args) {
		ArrayList<String> stuff = new ArrayList<String>();
		ArrayList<String> bags = new ArrayList<String>();
		ArrayList<Leaf> stuffComp = new ArrayList<Leaf>();
		ArrayList<Composite> bagComp = new ArrayList<Composite>();
		bags.add("Suitcase");
		bags.add("Backpack");
		bags.add("Vanity bag");

		for(int i=0; i<bags.size(); i++) {
			Composite root = new Composite(bags.get(i), 4-i);
			bagComp.add(root);
		}

		//Suitcase
		stuff.add("Jeans");
		stuff.add("Jumper");
		stuff.add("Socks");
		stuff.add("Beretta");
		//Backpack
		stuff.add("Pokeballs");
		stuff.add("Homework");
		//Vanity bag
		stuff.add("Shampoo");
		stuff.add("Soap");
		stuff.add("Lipstick");
		stuff.add("Happy pills");

		for(int i=0; i<stuff.size(); i++) {
			Leaf leaf = new Leaf(stuff.get(i), i);
			stuffComp.add(leaf);
		}

		for(int i=0;i<stuffComp.size();i++){
			if(i<4){
				if(i==0){
					bagComp.get(0).add(bagComp.get(1));
				}
				bagComp.get(0).add(stuffComp.get(i));
			}else if((i >= 4) && (i<6)){
				if(i==4){
					bagComp.get(1).add(bagComp.get(2));
				}
				bagComp.get(1).add(stuffComp.get(i));

			}else {
				bagComp.get(2).add(stuffComp.get(i));
			}
		}
		
		for(int i=0;i<bagComp.size(); i++){
			System.out.println(bagComp.get(i).toString()+" "+bagComp.get(i).getWeight());
		}
		System.out.println("START");
		Iterator iterator = bagComp.get(0).iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
	}

}
