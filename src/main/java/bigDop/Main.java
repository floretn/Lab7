package bigDop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Ring<Integer> ring = new ArrayRing<>(Arrays.asList(1, 5, 12, 66, 34, 172));
        System.out.println("Norm iterator");

        System.out.println(ring);
        Iterator<Integer> iterator = ring.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(ring);
        System.out.println(iterator.next());
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
            System.out.println("remove " + ring);
        }
        System.out.println(ring);

        ring = new ArrayRing<>(Arrays.asList(1, 5, 12, 66, 34, 172));
        iterator = ring.iterator();
        iterator.next();
        iterator.next();
        iterator.forEachRemaining(System.out::println);
        System.out.println();
        System.out.println();

        System.out.println("Reverse iterator");
        System.out.println(ring);
        iterator = ring.reverseItr();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(iterator.next());
        System.out.println(ring);
        iterator.forEachRemaining(System.out::println);
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
            System.out.println("remove " + ring);
        }
        ring = new ArrayRing<>(Arrays.asList(1, 5, 12, 66, 34, 172));
        iterator = ring.iterator();
        iterator.next();
        iterator.next();
        iterator.forEachRemaining(System.out::println);

        System.out.println("***************************************************************************");

        ring = new LinkedRing<>(Arrays.asList(1, 5, 12, 66, 34, 172));
        System.out.println("Norm iterator");

        System.out.println(ring);
        iterator = ring.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
            System.out.println("remove " + ring);
        }
        System.out.println(ring);

        ring = new LinkedRing<>(Arrays.asList(1, 5, 12, 66, 34, 172));
        iterator = ring.iterator();
        iterator.next();
        iterator.next();
        iterator.forEachRemaining(System.out::println);
        System.out.println();
        System.out.println();

        System.out.println("Reverse iterator");
        System.out.println(ring);
        iterator = ring.reverseItr();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(iterator.next());
        System.out.println(ring);
        iterator.forEachRemaining(System.out::println);
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
            System.out.println("remove " + ring);
        }
        ring = new LinkedRing<>(Arrays.asList(1, 5, 12, 66, 34, 172));
        iterator = ring.iterator();
        iterator.next();
        iterator.next();
        iterator.forEachRemaining(System.out::println);

    }
}
