package task13;

public class Task13 {

    public static void main(String[] args) {
        Cache<String, Integer> cache = new Cache<>(5);
        cache.put("Pacan1", 1);
        cache.put("Pacan2", 2);
        cache.put("Pacan3", 3);
        cache.put("Pacan4", 4);
        cache.put("Pacan5", 5);
        System.out.println(cache.entrySet());
        cache.put("Pacan6", 6);
        System.out.println(cache.entrySet());
    }
}
