package Uppg2;

class Woman extends Human {

	String name;
	String pnr;
	protected Woman(String name, String pnr) {
		super(name, pnr);
		this.name = name;
		this.pnr = pnr;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "JAK ER TJEJEN "+ name;
	}
	


}
