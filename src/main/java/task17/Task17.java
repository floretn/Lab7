package task17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task17 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(123);
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("HelloWorld!");
        list.addAll(arrayList);

        list = Collections.checkedList(new ArrayList<>(), Integer.class);
        arrayList = new ArrayList<>();
        arrayList.add("HelloWorld!");
        list.addAll(arrayList);
    }
}
