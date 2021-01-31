package oa.amazon.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * TIf the given string array is immutable, we use priority queue
 * If it is mutable, we use double linked list + map as LRU cache
 */
public class TopK {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(k, (a, b)-> map.get(a).compareTo(map.get(b)) == 0 ? b.compareTo(a) : map.get(a).compareTo(map.get(b)));

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            if (queue.contains(word)) {
                queue.remove(word);
            }
            queue.offer(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
