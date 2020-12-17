package task5;

import java.util.*;

public class Task5 {

    public static void  swap (List<?> list, int i, int j) {
        if (list instanceof RandomAccess){
            withRandomAccessSwap(list, i, j);
        }else {
            withNotRandomAccessSwap(list, i, j);
        }
    }

    private static <E> void withRandomAccessSwap(List<E> list, int i, int j){
        //System.out.println("Тут 3");
        list.set(i, list.set(j, list.get(i)));
    }

    private static <E> void withNotRandomAccessSwap(List<E> list, int i, int j){
        if (i > j){
            withNotRandomAccessSwap(list, j, i);
            return;
        }
        ListIterator<E> listIteratorI = list.listIterator(i);
        E nodeI = listIteratorI.next();
        if ((j - i) < (list.size() - j)){
            //System.out.println("Тут 1");
            ListIterator<E> listIteratorJ = list.listIterator(j);
            listIteratorI.set(listIteratorJ.next());
            listIteratorJ.set(nodeI);
        }else {
            //System.out.println("Тут 2");
            E nodeJ = null;
            for (int k = i; k <= j - 1; k++)
                nodeJ = listIteratorI.next();
            listIteratorI.set(nodeI);
            listIteratorI = list.listIterator(i);
            listIteratorI.next();
            listIteratorI.set(nodeJ);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>()
            {{add("s0"); add("s1"); add("s2"); add("s3"); add("s4"); add("s5"); add("s6"); add("s7"); add("s8"); }};

        swap(linkedList, 3, 6);
        System.out.println(linkedList);

        swap(linkedList, 1, 3);
        System.out.println(linkedList);

        ArrayList<String> arrayList = new ArrayList<>(linkedList);
        swap(arrayList, 0, 6);
        System.out.println(arrayList);

    }
}
