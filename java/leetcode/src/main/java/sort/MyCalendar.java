package sort;

import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer, Integer> book;
    public MyCalendar() {
        book = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer ceilingKey = book.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) {
            return false;
        }
        Integer floorKey = book.floorKey(start);
        if (floorKey != null && start < book.get(floorKey)) {
            return false;
        }
        book.put(start, end);
        return true;
    }
}
