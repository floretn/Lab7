package task15;

import java.util.AbstractList;
import java.util.List;
import java.util.function.IntFunction;

public class Method {

    public <T> List<T> methodGood(int n, IntFunction<T> function){ //TODO добавить верхнюю границу. Все методы листа, которые его не меняют, должны работать
        return new AbstractList<T>() {
            @Override
            public T get(int index) {
                if (index > n - 1){
                    throw new IndexOutOfBoundsException();
                }
                return function.apply(index);
            }

            @Override
            public int size() {
                return n;
            }

            @Override
            public Object[] toArray() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
