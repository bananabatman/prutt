package Uppg2;

class Man extends Human {

	String name;
	String pnr;
	protected Man(String name, String pnr) {
		super(name,  pnr);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.pnr = pnr;
	}
	
	public String toString() {
		return "JAK ER POJKEN "+ name;
	}
}
