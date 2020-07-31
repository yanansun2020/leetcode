package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Node> map = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<Node>(k, (o1, o2) -> o1.frequency == o2.frequency?
            o2.word.compareTo(o1.word) :o1.frequency - o2.frequency);
        for(String word: words){
            Node node = map.get(word);
            if(node == null){
                node = new Node();
                node.frequency = 1;
                node.word = word;
            }else {
                node.frequency += 1;
                queue.remove(node);
            }
            map.put(word, node);
            queue.add(node);
            if(queue.size() > k){
                queue.poll();
            }
        }
        List<String> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(queue.poll().word);
        }
        Collections.reverse(ans);
        return ans;
    }
    static class Node{
        String word;
        int frequency;

    }

    public static void main(String[] args) {
        String[] aa = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> result = topKFrequent(aa, 2);
        System.out.println(result);
        String[] bb = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        result = topKFrequent(bb, 4);
        System.out.println(result);
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(2);
//        int[] array = {2,3,1,7};
//        for(int s : array){
//            queue.add(s);
//            if (queue.size() > 2){
//                queue.poll();
//            }
//        }

    }

}
