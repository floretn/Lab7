package dop;

import java.time.MonthDay;
import java.util.*;

public class TMSvsHMS {

    public static Integer methodWithTreeMap(int coordinate, TreeMap<Integer, Integer> treeMap){
        Map.Entry<Integer, Integer> onBack = treeMap.lowerEntry(coordinate);
        if (onBack.getKey() == coordinate){
            return onBack.getKey();
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
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        fill(treeMap);
        System.out.println(methodWithTreeMap(125, treeMap));
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        fill(hashMap);
        System.out.println(methodWithHashMap(125, hashMap));
    }

    public static void fill(Map<Integer, Integer> map){
        map.put(0, 12);
        map.put(27, 16);
        map.put(39, 20);
        map.put(80, 21);
        map.put(101, 15);
        map.put(144, 35);
        map.put(210, 42);
        map.put(300, 19);
    }
}
