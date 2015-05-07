package Memory;

/**
 * Created by tonyf_000 on 2015-04-29.
 */
public class MemoryGame implements Boardgame {

    @Override
    public boolean move(int i, int j) {
        return true;
    }

    @Override
    public String getStatus(int i, int j) {
        return String.valueOf(i+j);
    }

    @Override
    public String getMessage() {
        return "1";
    }
}
