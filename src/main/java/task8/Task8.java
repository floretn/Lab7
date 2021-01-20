package task8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Task8 {

    /**
     * Плохой вариант
    String[] lines = stream.toArray(String[]::new);
     for (int i = 0; i < lines.length; i++){
        for (String word : lines[i].split(" ")){
            int j = i;
            treeMap.compute(word.trim(), (string, set) -> {
                if (!(set == null)) {
                    set.add(j);
                    return set;
                }else {
                    return new HashSet<Integer>(){{add(j);}};
                }
            });
        }
    }

     * Вариант с итератором;
     Iterator<String> iterator = stream.iterator();
     int itr = 1;
     while (iterator.hasNext()){
     for (String word : iterator.next().split(" ")){
     int j = itr;
     treeMap.compute(word.trim(), (string, set) -> {
     if (!(set == null)) {
     set.add(j);
     return set;
     }else {
     return new HashSet<Integer>(){{add(j);}};
     }
     });
     }
     itr++;
     }
     */

    public static TreeMap<String, Set<Integer>> readFile(String path) throws IOException {
        TreeMap<String, Set<Integer>> treeMap = new TreeMap<>();
        try(Stream<String> stream = Files.lines(Paths.get(path))) {
            //stream.close();
            int[] ints = new int[]{1};
            stream.forEach(s -> {
                for (String word : s.split("\\W")) {
                    int j = ints[0];
                    treeMap.compute(word, (string, set) -> {
                        if (!(set == null)) {
                            set.add(j);
                            return set;
                        } else {
                            return new HashSet<Integer>() {{
                                add(j);
                            }};
                        }
                    });
                }
                ints[0]++;
            });
        }
        return treeMap;
    }

    public static void main(String[] args) throws IOException {
        Map<String, Set<Integer>> Map = readFile("src/main/java/task8/file.txt");
        System.out.println(Map);
    }
}
