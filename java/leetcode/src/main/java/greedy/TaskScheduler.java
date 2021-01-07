package greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countMap = getFrequency(tasks);
        PriorityQueue<Character> queue = new PriorityQueue<Character>((o1, o2)->countMap.get(o2) - countMap.get(o1));
        queue.addAll(countMap.keySet());
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {
            List<Character> lst = new ArrayList<>();
            int i = 0;
            for (; i <= n && !queue.isEmpty(); i++) {
                Character c = queue.poll();
                lst.add(c);
                sb.append(c);
                countMap.put(c, countMap.get(c) - 1);
            }
            while (i <=n) {
                sb.append(" ");
                i++;
            }
            for (int j = 0; j < lst.size(); j++) {
                if (countMap.get(lst.get(j)) > 0) {
                    queue.offer(lst.get(j));
                }
            }
        }
        if (!queue.isEmpty()) {
            int tmpCount = 0;
            Integer num = countMap.get(queue.poll());
            tmpCount = (num - 1) * n + num;
            return sb.toString().length() + tmpCount;
        }
        return sb.toString().trim().length();
    }
    private Map<Character, Integer> getFrequency(char[] s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0;  i < s.length; i++) {
            map.put(s[i], 1 + map.getOrDefault(s[i], 0));
        }
        return map;
    }

    @Test
    public void test(){
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        int ans = leastInterval(tasks, 2);
        tasks = new char[]{'A','A','A','B','B','B'};
        ans = leastInterval(tasks, 0);
        tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
        ans = leastInterval(tasks, 2);
        tasks = new char[]{'A', 'B', 'A'};
        ans = leastInterval(tasks, 2);
    }
}
