package task7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task7 {

    public static TreeMap<String, Integer> readFile(String path) throws FileNotFoundException {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        Scanner sc = new Scanner(new File(path));
        while (sc.hasNext()){
            treeMap.merge(sc.next(), 1, Integer::sum);
        }
        return treeMap;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> Map = readFile("file.txt");
        System.out.println(Map);
    }
}
