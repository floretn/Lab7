package dop;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Navigator {

    int coordinate = 0;
    int lastCoordinate;
    Map.Entry<Integer, Tower> entry;
    Map.Entry<Integer, Tower> next;
    Tower tower;
    TreeMap<Integer, Tower> treeMap;
    HashMap<Integer, Tower> hashMap;

    public Navigator(int lastCoordinate, TreeMap<Integer, Tower> treeMap) {
        this.lastCoordinate = lastCoordinate;
        this.treeMap = treeMap;
        this.entry = treeMap.lowerEntry(treeMap.firstKey() + 1);
        this.next = treeMap.higherEntry(entry.getKey() + 1);
        tower = entry.getValue();
    }

    public Navigator(int lastCoordinate, HashMap<Integer, Tower> hashMap) {
        this.lastCoordinate = lastCoordinate;
        this.hashMap = hashMap;
        Map.Entry<Integer, Tower>[] towerEntries = find(null, null);
        this.entry = towerEntries[0];
        this.next = towerEntries[1];
    }

    public void goTree(){
        for (; coordinate < lastCoordinate; coordinate++){
            if (next != null) {
                if (coordinate == next.getKey()) {
                    entry = next;
                    next = treeMap.higherEntry(entry.getKey() + 1);
                    tower = entry.getValue();
                    System.out.println(entry);
                }
            }
        }
    }

    public void goHash(){
        for (; coordinate < lastCoordinate; coordinate++){
            if (next != null){
                if (coordinate == next.getKey()) {
                    Map.Entry<Integer, Tower>[] towerEntries = find(entry, next);
                    entry = towerEntries[0];
                    next = towerEntries[1];
                    tower = entry.getValue();
                    System.out.println(entry);
                }
            }
        }
    }

    private Map.Entry<Integer, Tower>[] find(Map.Entry<Integer, Tower> ... arr){
        if (arr[0] == null){
            int i = 0;
            for (Map.Entry<Integer, Tower> ent : hashMap.entrySet()){
                if (i == 0){
                    arr[0] = ent;
                    i++;
                    continue;
                }

                if (i == 1){
                    if (ent.getKey() > arr[0].getKey()){
                        arr[1] = ent;
                    }else{
                        arr[1] = arr[0];
                        arr[0] = ent;
                    }
                    i++;
                    continue;
                }

                if (arr[0].getKey() > ent.getKey()){
                    if (arr[1].getKey() > arr[0].getKey()) {
                        arr[1] = arr[0];
                    }
                    arr[0] = ent;
                    continue;
                }

                if (arr[1].getKey() > ent.getKey()){
                    arr[1] = ent;
                }
            }
            return arr;
        }

        Map.Entry<Integer, Tower> nextOld = arr[1];
        boolean check = true;

        for (Map.Entry<Integer, Tower> ent : hashMap.entrySet()){
            if (check && arr[1].getKey() < ent.getKey()){
                arr[1] = ent;
                check = false;
                continue;
            }

            if (arr[1].getKey() > ent.getKey() && nextOld.getKey() < ent.getKey()){
                arr[1] = ent;
            }
        }
        arr[0] = nextOld;
        return arr;
    }

    public static void main(String[] args) {
        TreeMap<Integer, Tower> treeMap = new TreeMap<>();
        fill(treeMap);
        (new Navigator(300, treeMap)).goTree();
        System.out.println("*****************************************************");
        HashMap<Integer, Tower> hashMap = new HashMap<>();
        fill(hashMap);
        (new Navigator(300, hashMap)).goHash();
    }

    public static void fill(Map<Integer, Tower> map){
        map.put(1, new Tower(1, 12, "t1"));
        map.put(12, new Tower(27, 16, "t2"));
        map.put(32, new Tower(39, 22, "t3"));
        map.put(64, new Tower(80, 24, "t4"));
        map.put(93, new Tower(101, 19, "tt"));
        map.put(124, new Tower(144, 9, "t6"));
        map.put(184, new Tower(210, 17, "t7"));
        map.put(255, new Tower(300, 29, "t8"));
    }
}
