package task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Task4Good {

    static class Clazz{
        int[] ints = new int[100];
        int cnt = 0;
        {
            add(20);
            add(303);
            add(666);
        }
        public void add(int i){
            ints[cnt] = i;
            cnt++;
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(19, 5, 33, 144, 5, 19));
        //List<Integer> list = Arrays.asList(19, 5, 33, 144, 5, 19);
        //List<Integer> list = new ArrayList<Integer>() {{add(19); add(5);}};
        //System.out.println(list.getClass());
        /*
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == 5){
                list.remove(i);
            }
        }

        */
        //list.removeIf(integer -> integer == 5);

        Iterator<Integer> iterator = list.iterator(); //TODO разобраться - asList(1,2,3) возвращает другой AL, который наследует абстрактный лист
        while (iterator.hasNext()){
            if (iterator.next() == 5){
                iterator.remove();
            }
        }

        int i = 0;
        for (Integer integer : list){
            if (integer == 5){
                list.remove(i);
            }
            i++;
        }
        System.out.println(list);
    }
}
