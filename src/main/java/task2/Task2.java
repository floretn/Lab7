package task2;

import java.util.Arrays;
import java.util.Iterator;

public class Task2 {

    public static String[] withIterator(String[] strings){
        Iterator<String> iterator = Arrays.stream(strings).iterator();
        String[] stringsNew = new String[strings.length];
        int i = 0;
        while (iterator.hasNext()){
            stringsNew[i] = iterator.next().toUpperCase();
            i++;
        }
        return stringsNew;
    }

    public static void withFor(String[] strings){
        for (int i = 0; i < strings.length; i++){
            strings[i] = strings[i].toUpperCase();
        }
    }

    public static void withReplaceAll(String[] strings){
        for (int i = 0; i < strings.length; i++){
            strings[i] = strings[i].replaceAll(strings[i], strings[i].toUpperCase());
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[] {"StRiNg", "string", "String", "sTrInG", "stRinG"};
        strings = withIterator(strings);
        System.out.println(Arrays.toString(strings));
        strings = new String[] {"StRiNg", "string", "String", "sTrInG", "stRinG"};
        withFor(strings);
        System.out.println(Arrays.toString(strings));
        strings = new String[] {"StRiNg", "string", "String", "sTrInG", "stRinG"};
        withReplaceAll(strings);
        System.out.println(Arrays.toString(strings));
    }
}
