package dop;

import java.util.*;

public class Calculating {


    /*
    public static Double methodWithTreeMap(int coordinate, TreeSet<Tower> treeSet){
        Tower onBack = treeSet.lower(new Tower(coordinate, 0, ""));
        if (onBack.getX() == coordinate){
            return onBack.getX();
        }

        Map.Entry<Integer, Integer>  onHead = treeMap.higherEntry(coordinate);

        if ((onHead.getKey() - coordinate) < (coordinate - onBack.getKey())){
            if ((onHead.getKey() - onHead.getValue()) < coordinate){
                return onHead.getKey();
            }

            if ((onBack.getKey() + onBack.getValue()) > coordinate){
                return onBack.getKey();
            }
        }else{
            if ((onBack.getKey() + onBack.getValue()) > coordinate){
                return onBack.getKey();
            }

            if ((onHead.getKey() - onHead.getValue()) < coordinate){
                return onHead.getKey();
            }
        }
        return null;
    }
    */

    public static Integer methodWithHashMap(int coordinate, HashMap<Integer, Integer> hashMap){
        Map.Entry<Integer, Integer> onBack = null;
        Map.Entry<Integer, Integer>  onHead = null;

        for (Map.Entry<Integer, Integer> k : hashMap.entrySet()){
            if ((onBack == null || k.getKey() > onBack.getKey()) && coordinate > k.getKey()){
                onBack = k;
            }
            if ((onHead == null || k.getKey() < onHead.getKey()) && coordinate <= k.getKey()){
                onHead = k;
            }
        }

        if ((onHead.getKey() - coordinate) < (coordinate - onBack.getKey())){
            if ((onHead.getKey() - onHead.getValue()) < coordinate){
                return onHead.getKey();
            }

            if ((onBack.getKey() + onBack.getValue()) > coordinate){
                return onBack.getKey();
            }
        }else{
            if ((onBack.getKey() + onBack.getValue()) > coordinate){
                return onBack.getKey();
            }

            if ((onHead.getKey() - onHead.getValue()) < coordinate){
                return onHead.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }

    private static void fill(Set<Tower> set){
        set.add(new Tower(0, 12, "one"));
        set.add(new Tower(27, 16, "Two"));
        set.add(new Tower(39, 20, "Three"));
        set.add(new Tower(80, 21, "Four"));
        set.add(new Tower(101, 15, "Five"));
        set.add(new Tower(144, 35, "Six"));
        set.add(new Tower(210, 42, "Seven"));
        set.add(new Tower(300, 19, "Eight"));
    }
}
