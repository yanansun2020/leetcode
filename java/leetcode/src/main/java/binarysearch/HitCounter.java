package binarysearch;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class HitCounter {
    TreeMap<Integer, Integer> map;
    LinkedList<Integer> queue;
    public HitCounter() {
        map = new TreeMap<>();
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        if (map.containsKey(timestamp)) {
            map.put(timestamp, map.get(timestamp) + 1);
            return;
        }
        int minTime = timestamp - 300 + 1;
        while (!queue.isEmpty() && queue.getFirst() < minTime) {
            Integer key = queue.removeFirst();
            map.remove(key);
        }
        queue.add(timestamp);
        map.put(timestamp, 1);
    }

    public int getHits(int timestamp) {
        int total = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getKey() <= timestamp) {
                total += map.get(e.getKey());
            }
        }
        return total;
    }
}
