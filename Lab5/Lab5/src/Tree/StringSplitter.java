package Tree;

import java.util.Scanner;

public class StringSplitter {
	
	public static void main(String[] args){
		Scanner newS = new Scanner(System.in);
		
		String abc = newS.nextLine();
		String[] result = abc.split("\"");
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
			System.out.println(result[0].split(" ")[0].substring(1));
			System.out.println(result[2].substring(2));
		}
		
	}

}
