package array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String a, String b){
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                }
                return -1;
            }
        });
        for (String num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
