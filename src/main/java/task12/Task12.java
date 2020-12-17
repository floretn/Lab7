package task12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task12 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("file.txt"));
        List<String> words = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
        words.set(0, words.get(0).toLowerCase());
        if (words.get(words.size() - 1).endsWith(".")){
            words.set(words.size() - 1, words.get(words.size() - 1).substring(0, words.get(words.size() - 1).length() - 1));
        }
        Collections.shuffle(words);
        words.set(0, words.get(0).toLowerCase());
        if (words.get(words.size() - 1).endsWith(".")){
            words.set(words.size() - 1, words.get(words.size() - 1).substring(0, words.get(words.size() - 1).length() - 1));
        }
        System.out.println(String.join(" ", words));
    }
}
