package bigDop;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.function.Consumer;

public class Test {
    LinkedList<Integer> ring = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
    Iterator<Integer> iterator = new Iterator<Integer>() {
        final ListIterator<Integer> li = ring.listIterator(ring.size() - 1);
        boolean check = true;

        @Override
        public boolean hasNext() {
            return li.hasPrevious();
        }

        @Override
        public Integer next() {
            if (check){
                check = false;
                return ring.getLast();
            }
            return li.previous();
        }

        @Override
        public void remove() {
            li.next();
            li.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super Integer> action) {
            while (this.hasNext()){
                action.accept(this.next());
            }
        }
    };

    public static void main(String[] args) {
        Test test = new Test();
        test.iterator.next();
        test.iterator.remove();
        System.out.println(test.ring);
        test.iterator.forEachRemaining(System.out::println);

    }
}
