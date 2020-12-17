package task10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task10 {

    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        Map<String, Set<Neighbor>> map = new HashMap<>();
        map.put("One", new HashSet<Neighbor>()
            {{add(new Neighbor("Two", 7)); add(new Neighbor("Three", 9));
                add(new Neighbor("Six", 14));}});
        map.put("Two", new HashSet<Neighbor>()
            {{add(new Neighbor("One", 7)); add(new Neighbor("Three", 10));
                add(new Neighbor("Four", 15));}});
        map.put("Three", new HashSet<Neighbor>()
            {{add(new Neighbor("One", 9)); add(new Neighbor("Six", 2)); add(new Neighbor("Two", 10));
                add(new Neighbor("Four", 11));}});
        map.put("Four", new HashSet<Neighbor>()
        {{add(new Neighbor("Two", 15)); add(new Neighbor("Three", 11)); add(new Neighbor("Five", 6));}});
        map.put("Five", new HashSet<Neighbor>()
            {{add(new Neighbor("Six", 9)); add(new Neighbor("Four", 6));}});
        map.put("Six", new HashSet<Neighbor>()
            {{add(new Neighbor("One", 14)); add(new Neighbor("Three", 9)); add(new Neighbor("Five", 9));}});
        Map<String, Integer> bestDistances = algorithm.algorithm("One", map);
        System.out.println(bestDistances);
    }
}
