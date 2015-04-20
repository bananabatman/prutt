package lab_2;

import java.util.Scanner;

//OBS! Det behövs inga import-satser i FifteenModel.
//FifteenModel innehåller ingen grafik !!!

class FifteenModel implements Boardgame {
	static int[][] playingField;
	private static int xNull;
	private static int yNull;
	private String moveOK; //0 är ok, 1 är out of bounds, 2 är ej bredvid null-ruta, 3 är diagonalt
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
				}
				else{
					xNull = i;
					yNull = j;

				}
			}
		}
	}


	@Override
	public boolean move (int i, int j) {
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
		System.out.println(i+ "  "+j);
		//Ta ut värdet på i,j
		int tempVal = playingField[i][j];
		//Sätt det värdet där xNull, yNull
		playingField[xNull][yNull] = tempVal;
		//Sätt xNull, yNull till i,j
		xNull = i;
		yNull = j;
		//Sätt null på nya xNull, yNull
		playingField[xNull][yNull] = 0;

	}

	@Override
	public String getStatus(int i, int j) {
		// TODO Auto-generated method stub
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
// Deklarera variabler och övriga metoder som ni anser behövs
// som behövs för ett femtonspel
