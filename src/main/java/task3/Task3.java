package task3;

import java.util.HashSet;
import java.util.Set;

public class Task3 {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>() {{add(1); add(2);}};
        Set<Integer> setNew = new HashSet<Integer>() {{add(2); add(3);}};
        Set<Integer> result = new HashSet<>();
        result.addAll(set);
        result.addAll(setNew);
        System.out.println(result);
        result.removeAll(setNew);
        System.out.println(result);
        result.add(3);
        result.add(4);
        set.add(4);
        result.retainAll(set);
        System.out.println(result);
    }

}
