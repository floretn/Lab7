package bigDop;

import java.util.*;
import java.util.function.Consumer;

public class LinkedRing<E> implements Ring<E> {

    LinkedList<E> ring;

    public LinkedRing() {
        this.ring = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "LinkedRing{" +
                "ring=" + ring.toString() +
                '}';
    }

    public LinkedRing(Collection<E> c) {
        this.ring = new LinkedList<>(c);
    }

    @Override
    public E getFirst() {
        return ring.getFirst();
    }

    @Override
    public E getLast() {
        return ring.getLast();
    }

    @Override
    public void add(int i, E e) {
        ring.add(i % ring.size(), e);
    }

    @Override
    public void remove(int i) {
        ring.remove(i % ring.size());
    }

    @Override
    public void set(int i, E e) {
        ring.set(i % ring.size(), e);
    }

    @Override
    public E get(int i) {
        return ring.get(i % ring.size());
    }

    @Override
    public Iterator<E> reverseItr() {
        return new Iterator<E>() {

            ListIterator<E> li = ring.listIterator(ring.size() - 1);
            boolean check = true;

            @Override
            public boolean hasNext() {
                return ring.size() != 0;
            }

            @Override
            public E next() {
                if (check){
                    check = false;
                    li.next();
                    return li.previous();
                }
                if (li.hasPrevious()) {
                    return li.previous();
                }
                li = ring.listIterator(ring.size() - 1);
                check = true;
                return this.next();
            }

            @Override
            public void remove() {
                li.remove();
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action) {
                for (int i = 0; i < ring.size(); i++){
                    action.accept(this.next());
                }
            }
        };
    }

    @Override
    public int size() {
        return ring.size();
    }

    @Override
    public boolean isEmpty() {
        return ring.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return ring.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            ListIterator<E> li = ring.listIterator();

            @Override
            public boolean hasNext() {
                return ring.size() != 0;
            }

            @Override
            public E next() {
                if (li.hasNext()) {
                    return li.next();
                }
                li = ring.listIterator();
                return this.next();
            }

            @Override
            public void remove() {
                li.remove();
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action) {
                for (int i = 0; i < ring.size(); i++){
                    action.accept(this.next());
                }
            }
        };
    }

    @Override
    public Object[] toArray() {
        return ring.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return ring.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return ring.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return ring.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return ring.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return ring.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return ring.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return ring.retainAll(c);
    }

    @Override
    public void clear() {
        ring.clear();
    }
}
