package lab_2;
public class MockObject implements Boardgame {
    Square[][] squareField;
    public MockObject(){

    }
    public boolean select(int i, int j) {
        return false;
    }

    @Override
    public boolean move(int i, int j) {
        return false;
    }

    @Override
    public String getStatus(int i, int j) {
        return "Status test";
    }

    @Override
    public String getMessage() {
        return "board test";
    }
}
