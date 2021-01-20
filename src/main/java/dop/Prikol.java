package dop;

import java.util.HashMap;
import java.util.Objects;

public class Prikol {

    static class NotImmutable{
        int a;
        int b;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public NotImmutable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NotImmutable that = (NotImmutable) o;
            return a == that.a && b == that.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return "NotImmutable{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    public static void main(String[] args) {
        HashMap<NotImmutable, Integer> hashMap = new HashMap<>();
        hashMap.put(new NotImmutable(1,1), 1);
        NotImmutable notImmutable = new NotImmutable(1, 3);
        hashMap.put(notImmutable, 123);
        notImmutable.a = 12;
        System.out.println(hashMap);
        System.out.println(hashMap.get(notImmutable));
        System.out.println(hashMap.get(new NotImmutable(1, 3)));
    }
}
