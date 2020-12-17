package task6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task6 {
    public static void main(String[] args) {
        Map<String, Set<Integer>> map = new HashMap<>();
        map.put("Reflection", new HashSet<Integer>() {{add(120); add(174);}});
        map.put("Arrays", new HashSet<Integer>() {{add(20); add(53);}});
        map.forEach((k, v) -> {
            System.out.print("About " + k + " you can read on pages ");
            v.forEach(g -> System.out.print(g + ", "));
            System.out.println();
        });
    }
}
