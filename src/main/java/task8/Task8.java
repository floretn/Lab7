package task8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Task8 {

    public static TreeMap<String, Set<Integer>> readFile(String path) throws IOException {
        TreeMap<String, Set<Integer>> treeMap = new TreeMap<>();
        Stream<String> stream = Files.lines(Paths.get(path));
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
        return treeMap;
    }

    public static void main(String[] args) throws IOException {
        Map<String, Set<Integer>> Map = readFile("file.txt");
        System.out.println(Map);
    }
}
