package oa.amazon.ftoa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * this implementation provides O(log(n)) time for the enqueing and dequeing methods (offer, poll, remove() and add);
 * linear time O(n) for the remove(Object) and contains(Object) methods;
 * and constant time O(1) for the retrieval methods (peek, element, and size)
 */
public class TopKFrequentlyMentionedKeywords {
    List<String> topK(int k, List<String> reviews, List<String> keywords){
        List<String> reviewList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        for (String review : reviews) {
            String[] reviewArray = review.split(" ");
            for (String word : reviewArray) {
                if (keywords.contains(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            reviewList.add(queue.poll().getKey());
        }
        return reviewList;
    }
    @Test
    public void test(){
        List<String> reviews = new ArrayList<>();
        reviews.add("Anacell provides the best services in the city");
        reviews.add("betacellular has awesome services");
        reviews.add("Best services provided by anacell, everyone should use anacell");
        List<String> keywords = new ArrayList<>();
        keywords.add("anacell");
        keywords.add("cetracular");
        keywords.add("betacellular");
        List<String> ans = topK(2, reviews, keywords);
    }
}
