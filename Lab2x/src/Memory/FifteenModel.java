package Memory;

import java.util.Scanner;

class FifteenModel implements Boardgame {
	static int[][] playingField;
	public static int xNull;
	public static int yNull;
	private String moveOK; //0 �r ok, 1 �r out of bounds, 2 �r ej bredvid null-ruta, 3 �r diagonalt
	public Scanner inputScan;
	
	public FifteenModel() {
		inputScan = new Scanner(System.in);
		playingField = new int[4][4];
		fill();
        System.out.println("Skriv först y-koordinaten och därefter x-koordinaten. 0.0 är rutan uppe t.v." +
                "\n" +" Notera att höger är ökande Y och nedåt är ökande X. Värden över 3 kommer inte att accepteras.");
	}

	private static void fill(){
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++){
				if(!(Integer.valueOf(i).equals(3) && Integer.valueOf(j).equals(3))){
					playingField[i][j] = ((i*4+j)+1);
				} else{
					xNull = i;
					yNull = j;
				}
			}
		}
	}

	@Override
	public boolean move (int i, int j) { // i,j motsvarar x,y koord för dest
		if (!(i<4 || j<4) || (i<0 || j<0)) {
			moveOK = "1";
			return false;
		} else if (Math.abs(i-xNull)>1) {
			moveOK = "2";
			return false;
		} else if (Math.abs(j-yNull)>1) {
			moveOK = "2";
			return false;
		} else if( Math.abs((Math.abs(j-yNull))-(Math.abs(i-xNull))) <1){
			moveOK = "3";
			return false;
		} else {
			moveOK = "0";
			this.swap(i,j);
			return true;
		}
	}

	private void swap(int i, int j){

		int tempVal = playingField[i][j];
		playingField[xNull][yNull] = tempVal;
		xNull = i;
		yNull = j;
		playingField[xNull][yNull] = 0;
	}


	@Override
	public String getStatus(int i, int j) {
		return String.valueOf(playingField[i][j]);
	}

	@Override
	public String getMessage() {
		if (moveOK.equals("0")) {
			return "Move OK.";
		} else if (moveOK.equals("1")) {
			return "Coordinates not within board, douche.";
		} else if (moveOK.equals("3")) {
			return "Diagonal movement isn't permitted, cheater";
		} return "Illegal move, not next to null-space noob."; 
	}
}


// Implementera Boardgame-metoderna
// Deklarera variabler och �vriga metoder som ni anser beh�vs
// som beh�vs f�r ett femtonspel
