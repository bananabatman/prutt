package Memory;

import java.util.HashMap;

/**
 * Created by tonyf_000 on 2015-04-29.
 */
public class MemoryGame implements Boardgame {
	static String[][] playingField;
	int squaresClicked;
	boolean moveOK;
	int numMove;
	static String firstSquare;
	static String secondSquare;
	String selectedSquare; //OM vi måste kolla dubbelklick
	static HashMap<String, String> displayHash;
	public MemoryGame(){
		firstSquare = "AN";
		secondSquare = "NA";
		numMove = 0;
		playingField = new String[4][4];
		displayHash = new HashMap<String, String>();
		displayHash.put("1A","");
		displayHash.put("1B","");
		displayHash.put("2A","");
		displayHash.put("2B","");
		displayHash.put("3A","");
		displayHash.put("3B","");
		displayHash.put("4A","");
		displayHash.put("4B","");
		displayHash.put("5A","");
		displayHash.put("5B","");
		displayHash.put("6A","");
		displayHash.put("6B","");
		displayHash.put("7A","");
		displayHash.put("7B","");
		displayHash.put("8A","");
		displayHash.put("8B","");
		fill();
	}
	private static void fill(){
		String[] squareVals = displayHash.keySet().toArray(new String[0]);
		System.out.println(squareVals[0]);
		//Måste vi slumpa? :(		
		for(int i=0; i<4; i++){
			for(int j=0;j<4;j++){
				playingField[i][j] = squareVals[(i*4+j)];
			}
		}
	}

	@Override
	public boolean move(int i, int j) {
		numMove = 0;
		System.out.println("clicks: "+squaresClicked);
		//när move true --> viewcontrol kallar på relabel som kallar på getstatus --> ruta byter från blank till siffra
		if(squaresClicked==0){ // Första rutan klickad
			if(!compare(firstSquare, secondSquare)){
				displayHash.put(firstSquare, "");
				displayHash.put(secondSquare, "");
			}
			firstSquare = playingField[i][j];
			displayHash.put(firstSquare, firstSquare.substring(0,1));
			squaresClicked++;
			numMove = 1; //Välj en till
			return true;
		} else if(squaresClicked==1){ // Andra rutan klickad
			//Måste jämför rutornas innehåll  när squaresClicked är 1
			secondSquare = playingField[i][j];
			squaresClicked = 0;
			displayHash.put(secondSquare, secondSquare.substring(0,1));
			return true;
		} else {
			System.out.println("NÅGOT GICK FEL");
			return false;
		}
	}

	public boolean compare(String first, String second){
		if(!(first.substring(0,1).equals(second.substring(0,1)))){
			moveOK = false;
			numMove = 2; //Inte ett par
		} else {
			moveOK = true;
			numMove = 3; //All is well
		}
		return moveOK;
		
	}
	
	@Override
	public String getStatus(int i, int j) {
		//get status bestämmer vad relabel sätter för label
		//return hashmap.value(playingField[i][j]);
		return displayHash.get(	playingField[i][j]);
	}

	@Override
	public String getMessage() {
		if (numMove ==0){
			return "Pick a square";
		} else if (numMove == 1){
			return "Select a second square";
		} else if (numMove == 2){
			return "That wasn't a match";
		} else if (numMove == 3){
			return "TRES BIEN";
		} else {
			return "????";
		}
	}

	//Slumpa ut x antal par av siffror 
	//Begränsning: får välja 2 rutor
	//rutors värde visas
	//när två rutor har valts - kör kontroll om matchning
	//Om match - låt vara permanent visible
	//Annars - blanka igen

}