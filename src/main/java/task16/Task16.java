package task16;

import java.util.List;

public class Task16 {

    public static void main(String[] args) {

        Method method = new Method();
        List<String> list = method.methodGood(s -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s; i++){
                sb.append("A");
            }
            return sb.toString();
        });

        System.out.println(list.get(5));
        System.out.println(list.get(1));
        System.out.println(list.get(23));
        System.out.println(list.get(23));
        System.out.println(list.get(29));
    }
}
