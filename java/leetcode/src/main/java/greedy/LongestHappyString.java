package greedy;

import java.util.PriorityQueue;

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
    PriorityQueue<Freq> queue = new PriorityQueue<>((o1, o2) -> o2.freq - o1.freq);
    if (a > 0) {
        queue.offer(new Freq("a", a));
    }
    if (b > 0) {
        queue.offer(new Freq("b", b));
    }
    if (c > 0) {
        queue.offer(new Freq("c", c));
    }
    StringBuilder sb = new StringBuilder();
    while (queue.size() > 0 && !queue.peek().s.equals(sb.charAt(sb.length() - 1))){
        Freq first = queue.poll();
        Freq second = queue.poll();
        if (first.freq >= 2) {
            sb.append(first.s);
            sb.append(first.s);
            first.freq -= 2;
        } else {
            sb.append(first.s);
            first.freq -= 1;
        }

        if (second.freq >= 2) {
            sb.append(second.s);
            sb.append(second.s);
            second.freq -= 2;
        } else {
            sb.append(second.s);
            second.freq -= 1;
        }
        if (first.freq > 0) {
            queue.offer(first);
        }
        if (second.freq > 0) {
            queue.offer(second);
        }
    }

    if (!queue.isEmpty() ) {
        Freq last = queue.poll();
        return insertLast(last, sb.toString());

    }
    //sb.reverse();
    return sb.toString();
}
    private String insertLast(Freq last, String s){
        int freq = last.freq;
        int i = 0;
        while (freq > 0 && i < s.length()) {
            if (!last.s.equals(s.charAt(i))) {
                if (freq >= 2) {
                    s = s.substring(0, i) + last.s + last.s + s.substring(i + 1) ;
                }else {
                    s = s.substring(0, i) + last.s + s.substring(i + 1) ;
                }
            }
            i++;
        }
        return s;
    }
}
class Freq{
    String s;
    Integer freq;
    Freq(){}
    Freq(String s, Integer freq){
        this.s = s;
        this.freq = freq;
    }
}
