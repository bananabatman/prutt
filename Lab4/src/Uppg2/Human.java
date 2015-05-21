package Uppg2;

public class Human {
	
	protected Human(String name, String pnr) {
	}
	
	public static Man create (String name, String pnr) {
		Man human = null;
		int checkDigit = Integer.valueOf(pnr.substring(pnr.length()-2,  pnr.length()-1));
		//pnr: YYMMDD-XXXX
		if ((checkDigit % 2)==0) {
			//Om den är jämn returneras en kvinna
			//human = new Woman(name, pnr);
		} else if ((checkDigit % 2)==1) {
			human = new Man(name, pnr);
			/*Om näst sista siffran i pnr är udda ska en Man returneras*/
		}
		return human;
    }
	
	public String toString() {
		return "lmao";
	}
	
	private static class Man extends Human{

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


}
