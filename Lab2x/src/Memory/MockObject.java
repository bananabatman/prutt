package Memory;

public class MockObject implements Boardgame{
    @Override
    public boolean move(int i, int j) {
        return false;
    }

    @Override
    public String getStatus(int i, int j) {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
