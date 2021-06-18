package sort;

import java.util.TreeMap;

public class MyCalendarTwo {
    TreeMap<Integer, int[]> map;
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floorKey = map.floorKey(start);
        Integer ceilingKey = map.ceilingKey(start);
        if (floorKey == null && ceilingKey == null) {
            map.put(start, new int[]{end, 1});
            return true;
        }
        if (floorKey != null && ceilingKey != null && floorKey != ceilingKey) {
            return check(start, end, floorKey, ceilingKey);
        }
        if (floorKey != null) {
            return check(start, end, floorKey);
        }
        return check(start, end, ceilingKey);
    }
    
    private boolean check(int start, int end, int floorKey, int ceilingKey) {
        int[] floorValues = map.get(floorKey);
        int[] ceilingValues = map.get(ceilingKey);
        boolean preOverlap = overlap(start, end, floorKey, floorValues[0]);
        boolean nextOverlap = overlap(start, end, ceilingKey, ceilingValues[0]);
        if (preOverlap && floorValues[1] == 2) {
            return false;
        }
        if (nextOverlap && ceilingValues[1] == 2) {
            return false;
        }
        if (preOverlap && nextOverlap) {
            update(start, ceilingKey, floorKey, floorValues[0]);
            update(ceilingKey, end, ceilingKey, ceilingValues[0]);
            return true;
        }
        if (preOverlap){
            update(start, end, floorKey, floorValues[0]);
            return true;
        }
        update(start, end, ceilingKey, ceilingValues[0]);
        return true;
    }
        
    private boolean check(int start, int end, int key) {
        int[] values = map.get(key);
        if (overlap(start, end, key, values[0])) {
            if(values[1] == 2) {
                return false;
            }
            update(start, end, key, values[0]);
        } else {
            map.put(start, new int[]{end, 1});
        }
        return true;
    }
    
    private void update(int s1, int e1, int s2, int e2) {
        int[] intervals = getIntervals(s1, e1, s2, e2);
        map.remove(s2);
        if (intervals[0] != intervals[1]) {
            map.put(intervals[0], new int[]{intervals[1], 1});
        }
        if (intervals[1] != intervals[2]) {
            map.put(intervals[1], new int[]{intervals[2], 2});
        }
        if (intervals[2] != intervals[3]) {
            map.put(intervals[2], new int[]{intervals[3], 1});
        }
    }
    
    
    private int[] getIntervals(int s1, int e1, int s2, int e2) {
        int[] values = new int[4];
        values[0] = Math.min(s1, s2);
        values[3] = Math.max(e1, e2);
        values[1] = Math.max(s1, s2);
        values[2] = Math.min(e1, e2);
        return values;
    }
    private boolean overlap(int s1, int e1, int s2, int e2) {
        return (Math.min(e1, e2) > Math.max(s1, s2));
    }
    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        boolean book = myCalendarTwo.book(24, 40);
        book = myCalendarTwo.book(43, 50);
        book = myCalendarTwo.book(27, 43);
        book = myCalendarTwo.book(5, 21);
        book = myCalendarTwo.book(30, 40);
        book = myCalendarTwo.book(14, 29);
    }
}
