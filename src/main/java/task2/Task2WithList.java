package task2;

import java.util.*;

public class Task2WithList {

    public static void withIterator(List<String> strings){
        ListIterator<String> iterator = strings.listIterator();
        while (iterator.hasNext()){
            iterator.set(iterator.next().toUpperCase());
        }
    }

    public static void withFor(List<String> strings){
        for (int i = 0; i < strings.size(); i++){
            strings.set(i, strings.get(i).toUpperCase());
        }
    }

    public static void withReplaceAll(List<String> strings){
        strings.replaceAll(String::toUpperCase);
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>()
            {{add("StRiNg"); add("string"); add("String"); add("sTrInG"); add("stRinG");}};
        withIterator(strings);
        System.out.println(strings);
        strings = new ArrayList<String>()
            {{add("StRiNg"); add("string"); add("String"); add("sTrInG"); add("stRinG");}};
        withFor(strings);
        System.out.println(strings);
        strings = new ArrayList<String>()
            {{add("StRiNg"); add("string"); add("String"); add("sTrInG"); add("stRinG");}};
        withReplaceAll(strings);
        System.out.println(strings);
    }
}
