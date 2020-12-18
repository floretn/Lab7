package task14;

import java.util.Arrays;
import java.util.List;

public class Task14 {

    public static void main(String[] args) {
        Method method = new Method(3);
        System.out.println(method.method());
        System.out.println(method.method());
        System.out.println(method.method());
        System.out.println(method.method());
        System.out.println(method.method());
        System.out.println(method.method());

        List<Integer> list = method.methodGood(4);
        System.out.println(list);
        System.out.println(list.size());
    }
}
