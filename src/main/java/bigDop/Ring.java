package bigDop;

import java.util.Collection;
import java.util.Iterator;

public interface Ring<E> extends Collection<E> {
    public E getFirst();
    public E getLast();
    public void add(int i, E e);
    public void remove(int i);
    public void set(int i, E e);
    public E get(int i);
    public Iterator<E> reverseItr();
}
