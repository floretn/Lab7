package task1;

import java.util.*;

public class Task1 {

    public static HashSet<Integer> withHashSet(int n){
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 2; i <= n; i ++){
            hashSet.add(i);
        }
        for (int p = 2; p*p <= n; p++){
            for (int i = p*p; i <= n; i+=p){
                hashSet.remove(i);
            }
        }
        return hashSet;
    }

    public static BitSet withBitSet(int n){
        BitSet bitSet = new BitSet(n);
        for (int i = 2; i <= n; i ++){
            bitSet.set(i);
        }
        for (int p = 2; p*p <= n; p++){
            for (int i = p*p; i <= n; i+=p){
                bitSet.clear(i);
            }
        }
        return bitSet;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите n: ");
        int n = sc.nextInt();
        Set<Integer> set = withHashSet(n);
        System.out.println("With HashSet:");
        set.forEach(System.out::println);

        BitSet bitSet = withBitSet(n);
        System.out.println("With BitSet:");
        System.out.println(Arrays.toString(bitSet.stream().toArray()));
    }
}
