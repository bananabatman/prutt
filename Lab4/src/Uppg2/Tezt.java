package Uppg2;




public class Tezt {
	
	
	public static void main (String[] args) {
		Human anna = Human.create("Anna", "xxxxxx-013x");
	    Uppg2.Human magnus = Human.create("Magnus","xxxxxx-011x");
	    System.out.println(anna);
	    System.out.println(magnus);
	    Man man = new Man("Magnus","xxxxxx-011x");
	    Woman newWoman = new Woman("Magnus","xxxxxx-011x");

	    //Human h = new Human(){};
	   // Woman coolWoman = Woman.create("olof", "123");
	}
}
