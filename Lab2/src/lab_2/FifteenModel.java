package lab_2;

import java.util.Scanner;

//OBS! Det beh�vs inga import-satser i FifteenModel.
//FifteenModel inneh�ller ingen grafik !!!

class FifteenModel implements Boardgame {
	static int[][] playingField;
    Square[][] squareField;
	private static int xNull;
	private static int yNull;
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
				}
				else{
					xNull = i;
					yNull = j;

				}
			}
		}
	}

    public Square[][] makeButtons(int n){
        squareField = new Square[n][n];
        String id;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!(Integer.valueOf(i).equals(3) && Integer.valueOf(j).equals(3))){
                    id = Integer.toString((i*4+j)+1);
                    squareField[i][j] = new Square(id,j,i);
                } else{
                    squareField[i][j] = new Square("0", j, i);
                }


            }
        }
    return squareField;
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
/*
    public boolean move (Square one, Square two) {
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
    }*/


	private void swap(int i, int j){
		System.out.println(i+ "  "+j);
		//Ta ut v�rdet p� i,j
		int tempVal = playingField[i][j];
		//S�tt det v�rdet d�r xNull, yNull
		playingField[xNull][yNull] = tempVal;
		//S�tt xNull, yNull till i,j
		xNull = i;
		yNull = j;
		//S�tt null p� nya xNull, yNull
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
// Deklarera variabler och �vriga metoder som ni anser beh�vs
// som beh�vs f�r ett femtonspel
