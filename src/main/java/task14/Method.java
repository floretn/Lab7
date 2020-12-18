package task14;

import java.util.AbstractList;
import java.util.List;

public class Method {

    private final int n;
    private int current = -1;

    public Method(int n){
        this.n = n;
    }

    public Integer method(){
        if (current < n) {
            current++;
            return current;
        } else {
            return null;
        }
    }

    public List<Integer> methodGood(int n1){
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                if (index >= 0 && index <= n1){
                    return index;
                }
                return null;
            }

            @Override
            public int size() {
                return n1 +1;
            }
        };
    }
}
