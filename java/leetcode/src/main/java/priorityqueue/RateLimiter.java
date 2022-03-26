package priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RateLimiter {
    Map<String, Limiter> map; // msg : lst print timestamp
    int limiter;
    PriorityQueue<Limiter> queue;
    public RateLimiter() {
        map = new HashMap<>();
        limiter = 10;
        queue = new PriorityQueue<>((e1, e2) -> e1.value - e2.value);
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && timestamp - queue.peek().value >= limiter) {
            Limiter removedLimiter = queue.poll();
            map.remove(removedLimiter.key);
        }
        if(!map.containsKey(message)){
            Limiter limiter = new Limiter(message, timestamp);
            map.put(message, limiter);
            queue.offer(limiter);
            return true;
        }
        return false;
    }
}


class Limiter{
    String key;
    Integer value;
    Limiter(String key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
