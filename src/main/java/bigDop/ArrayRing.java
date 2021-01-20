package bigDop;

import java.util.*;
import java.util.function.Consumer;

public class ArrayRing<E> implements Ring<E>, RandomAccess {

    private List<E> ring;
    private int numOfChanges = 0;

    public ArrayRing() {
        this.ring = new ArrayList<>();
    }

    public ArrayRing(Collection<E> c) {
        this.ring = new ArrayList<>(c);
    }

    @Override
    public String toString() {
        return "ArrayRing{" +
                "ring=" + ring.toString() +
                '}';
    }

    @Override
    public E getFirst() {
        return ring.get(0);
    }

    @Override
    public E getLast() {
        return ring.get(ring.size() - 1);
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
    public E get(int i){
        return ring.get(i  % ring.size());
    }

    @Override
    public Iterator<E> reverseItr() {
        return new Iterator<E>() {

            int currentInd = ring.size();
            int numOfChangesBefore = numOfChanges;
            boolean check = true;

            @Override
            public boolean hasNext() {
                return ring.size() != 0;
            }

            @Override
            public E next() {
                if (numOfChangesBefore != numOfChanges){
                    throw new ConcurrentModificationException();
                }
                if (currentInd == 0){
                    currentInd = ring.size();
                }
                currentInd--;
                check = false;
                return ring.get(currentInd);
            }

            @Override
            public void remove() { //TODO ошибка
                /*
                if (currentInd == 0){
                    ring.remove(ring.size() - 1);
                    return;
                }
                ring.remove(--currentInd);
                numOfChangesBefore++;
                numOfChanges++;
                */
                if (check){
                    throw new IllegalStateException();
                }
                ring.remove(currentInd);
                check = true;
                numOfChangesBefore++;
                numOfChanges++;
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

            int currentInd = -1;
            int numOfChangesBefore = numOfChanges;
            boolean check = true;

            @Override
            public boolean hasNext() {
                return ring.size() != 0;
            }

            @Override
            public E next() {
                if (numOfChangesBefore != numOfChanges){
                    throw new ConcurrentModificationException();
                }
                if (currentInd == ring.size() - 1){
                    currentInd = -1;
                }
                currentInd++;
                check = false;
                return ring.get(currentInd);
            }

            @Override
            public void remove() {
                /*
                if ((currentInd + 1) == ring.size()){
                    ring.remove(0);
                    currentInd--;
                    return;
                }
                ring.remove(currentInd + 1);
                numOfChangesBefore++;
                numOfChanges++;
                */
                if (check){
                    throw new IllegalStateException();
                }
                check = true;
                numOfChangesBefore++;
                numOfChanges++;
                ring.remove(currentInd);
                currentInd--;
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
        numOfChanges++;
        return ring.add(e);
    }

    @Override
    public boolean remove(Object o) {
        if (ring.remove(o)) {
            numOfChanges++;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return ring.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (ring.addAll(c)) {
            numOfChanges++;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (ring.removeAll(c)) {
            numOfChanges++;
            return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (ring.retainAll(c)) {
            numOfChanges++;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        ring.clear();
    }
}
