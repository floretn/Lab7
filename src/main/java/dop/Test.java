package dop;

import java.util.*;

public class Test {

    List list;
    LinkedList linkedList;
    ArrayList arrayList;
    NavigableSet navigableSet;
    SortedSet sortedSet;
    HashSet hashSet;
    TreeSet treeSet;
    NavigableMap navigableMap;
    SortedMap sortedMap;
    HashMap hashMap;
    TreeMap treeMap;
    Queue queue;
    Deque deque;
    Iterable iterable;
    Iterator iterator;
    RandomAccess randomAccess;
    BitSet bitSet;
    Properties properties;
    EnumSet enumSet;
    WeakHashMap weakHashMap;

    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        BitSet bitSet = new BitSet();
        bitSet.set(123);
        System.out.println(bitSet);
    }
}
