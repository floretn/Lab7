package task13;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache<K, V> extends LinkedHashMap<K, V> {

    private int maxEntries;

    private Cache() {
        super();
    }

    public Cache(int maxEntries) {
        super();
        this.maxEntries = maxEntries;
    }

    public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return super.size() > maxEntries;
    }

    public int getMaxEntries() {
        return maxEntries;
    }

    public void setMaxEntries(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    @Override
    public String toString() {
        return "Cache{" +
                "maxEntries=" + maxEntries +
                '}';
    }
}
