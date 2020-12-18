package task16;

import task13.Cache;

import java.util.AbstractList;
import java.util.List;
import java.util.function.IntFunction;

public class Method {

    public <T> List<T> methodGood(IntFunction<T> function){
        return new AbstractList<T>() {
            private final Cache<Integer, T> cache = new Cache<>(3); //100
            @Override
            public T get(int index) {
                if (cache.containsKey(index)){
                    return cache.get(index);
                }
                T rez = function.apply(index);
                cache.put(index, rez);
                //System.out.println(cache.entrySet());
                return rez;
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
