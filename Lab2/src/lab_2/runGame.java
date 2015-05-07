package lab_2;

/**
 * Created by tonyf_000 on 2015-04-29.
 */
public class runGame {

    public static void main(String[] args){
        FifteenModel newMod = new FifteenModel();
        ViewControl newView = new ViewControl(newMod, Integer.valueOf(args[0]));
    }
}


