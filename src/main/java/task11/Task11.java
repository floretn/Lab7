package task11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Task11 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("file.txt"));
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
        Collections.shuffle(arrayList.subList(1, arrayList.size() - 1));
        System.out.println(arrayList);
    }
}
