package Memory;

/**
 * Created by tonyf_000 on 2015-04-29.
 */
public class runMemory {

    public static void main(String[] args){
        MemoryGame newMod = new MemoryGame();
        ViewControl newView = new ViewControl(newMod, Integer.valueOf("4"));
    }
}
