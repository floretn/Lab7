package task18;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task18 {

    private List<Integer> list = Collections.emptyList();
    private List<Integer> listTwo = Collections.EMPTY_LIST;

    public Task18() {
    }

    public void init(List<Integer> list, List<Integer> listTwo) {
        System.out.println(list.size());
        this.list = list;
        this.listTwo = listTwo;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        // ????
    }
}
