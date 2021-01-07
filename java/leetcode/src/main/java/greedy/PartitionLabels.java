package greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Interval> intervalMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++){
            Interval interval = intervalMap.getOrDefault(S.charAt(i), new Interval(i, i));
            interval.end = i;
            intervalMap.put(S.charAt(i), interval);
        }
        List<Interval> intervals = mergeInterval(intervalMap);
        List<Integer> ans = new ArrayList<>();
        for (int i = intervals.size() - 1; i >= 0; i--) {
            ans.add(intervals.get(i).end - intervals.get(i).start + 1);
        }
        return ans;
    }

    List<Interval> mergeInterval(Map<Character, Interval> intervalMap){
        List<Interval> intervalList = new ArrayList<>();
        for (Map.Entry<Character, Interval> entry : intervalMap.entrySet()){
            intervalList.add(entry.getValue());
        }
        Collections.sort(intervalList, ((o1, o2) -> o1.start - o2.start));
        LinkedList<Interval> mergedList = new LinkedList<>();
        for (Interval interval : intervalList) {
            if (mergedList.isEmpty()) {
                mergedList.addFirst(interval);
            } else {
                Interval first = mergedList.getFirst();
                if (isOverlap(first, interval)) {
                    mergedList.removeFirst();
                    Interval newInterval = new Interval(Math.min(first.start, interval.start), Math.max(first.end, interval.end));
                    mergedList.addFirst(newInterval);
                } else {
                    mergedList.addFirst(interval);
                }
            }
        }
        return mergedList;
    }
    private boolean isOverlap(Interval i1, Interval i2){
        return i2.start >= i1.start && i2.start <= i1.end;
    }

    @Test
    public void test(){
        List<Integer> ans = partitionLabels("abac");
    }
}

class Interval{
    int start;
    int end;
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
