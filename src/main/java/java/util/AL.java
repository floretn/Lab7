package java.util;

public class AL extends ArrayList<Integer> {

    public void ex() throws MyException {
        throw new MyException();
    }
    @Override
    public void clear() {
        super.clear();
        try {
            ex();
        } catch (MyException e) {
            throw new RuntimeException("", e);
        }
    }
}
