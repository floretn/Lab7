package task9;

import java.util.HashMap;
import java.util.Map;

public class Task9 {

    public static void withMerge(String word, Map<String, Integer> map) {
        map.merge(word, 1, Integer::sum);
    }

    public static void withContains(String word, Map<String, Integer> map) {
        if (map.containsKey(word)){
            map.replace(word, map.get(word) + 1);
        } else {
            map.put(word, 1);
        }
    }

    public static void withGet(String word, Map<String, Integer> map) {
        if (map.get(word) != null){
            map.replace(word, map.get(word) + 1);
        } else {
            map.put(word, 1);
        }
    }

    public static void withReplace(String word, Map<String, Integer> map) {
        map.put(word, map.getOrDefault(word, 0) + 1);
    }

    public static void withPutIfAbsent(String word, Map<String, Integer> map) {
        Integer v = map.putIfAbsent(word, 1);
        if (v != null) {
            map.put(word, v + 1);
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("StringOne", 1);
        map.put("StringTwo", 1);
        withMerge("StringThree", map);
        withMerge("StringThree", map);
        System.out.println("Merge: ");
        System.out.println(map);
        System.out.println("******************************");
        withContains("StringThree", map);
        withContains("StringFour", map);
        System.out.println("Contains: ");
        System.out.println(map);
        System.out.println("******************************");
        withGet("StringThree", map);
        withGet("StringFive", map);
        System.out.println("Get: ");
        System.out.println(map);
        System.out.println("******************************");
        withReplace("StringThree", map);
        withReplace("StringSex", map);
        System.out.println("Get: ");
        System.out.println(map);
        System.out.println("******************************");
        withPutIfAbsent("StringThree", map);
        withPutIfAbsent("StringSeven", map);
        System.out.println("PutIfAbsent: ");
        System.out.println(map);
        System.out.println("******************************");

    }

}
