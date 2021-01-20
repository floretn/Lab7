package task15;

import java.util.Arrays;
import java.util.List;

public class Task15 {

    public static void main(String[] args) {
        Method method = new Method();
        List<String> list = method.methodGood(10, s -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s; i++){
                sb.append("A");
            }
            return sb.toString();
        });

        List<String> subList = list.subList(2, 5);

        for (String s : list){
            System.out.println(s);
        }


        System.out.println(list.get(5));
        System.out.println(list.get(1));
        System.out.println(list.get(0));
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
        //System.out.println(list.get(23));
    }
}
