package task4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Task4Bad {

    public static void main(String[] args) {
        List<Integer> list
                = new ArrayList<Integer>(){{ add(1); add(2); add(2); add(3);}};
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()){
            Integer j = iterator.next();
            if (j.equals(1) || j.equals(2)){
                iterator.remove();
            }
        }
        System.out.println(list);

        list = new ArrayList<Integer>(){{ add(1); add(2); add(2); add(3);}};
        iterator = list.listIterator();
        ListIterator<Integer> iterator1 = list.listIterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(1)){
                iterator.remove();
            }

            if (iterator1.next().equals(2)){
                iterator1.remove();
            }
        }
        System.out.println(list);
    }
}
