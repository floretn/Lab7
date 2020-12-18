package task15;

import java.util.AbstractList;
import java.util.List;
import java.util.function.IntFunction;

public class Method {

    public <T> List<T> methodGood(IntFunction<T> function){
        return new AbstractList<T>() {
            @Override
            public T get(int index) {
                return function.apply(index);
            }

            @Override
            public int size() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Object[] toArray() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
