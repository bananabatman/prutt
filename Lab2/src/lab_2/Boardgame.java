package lab_2;

public interface Boardgame {
	   public boolean move(int i, int j); //returnerar true om draget gick bra, annars false 
	   public String getStatus(int i, int j);
	   public String getMessage();
	}