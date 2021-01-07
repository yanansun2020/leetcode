package greedy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * sort by frequency
 * Each time select k different chs
 * If there isn't key distinct chars, then check if any left char has frequency > 1
 *
 */
public class RearrangeStringkDistanceApart {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> countMap = getFrequency(s);
        PriorityQueue<Character> queue = new PriorityQueue<Character>((o1, o2)->countMap.get(o2).compareTo(countMap.get(o1))==0  ? o1 - o2 : countMap.get(o2) - countMap.get(o1));
        queue.addAll(countMap.keySet());
        if (k == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() >= k){
            char[] array = new char[k];
            for (int i = 0; i < k; i++) {
                Character ch = queue.poll();
                sb.append(ch);
                countMap.put(ch, countMap.get(ch) - 1);
                array[i] = ch;
            }
            for (int i = 0; i < k; i++) {
                if (countMap.get(array[i]) > 0) {
                    queue.offer(array[i]);
                }
            }
        }
        StringBuilder sb1 = new StringBuilder();
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            if (countMap.get(c) > 1) {
                return "";
            } else {
                sb1.append(c);
            }
        }
        sb.append(sb1);
        return sb.toString();
    }
    private Map<Character, Integer> getFrequency(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0;  i < s.length(); i++) {
            map.put(s.charAt(i), 1 + map.getOrDefault(s.charAt(i), 0));
        }
        return map;
    }
    @Test
    public void test(){
        String ans = rearrangeString(""
            , 26);
    }
}
