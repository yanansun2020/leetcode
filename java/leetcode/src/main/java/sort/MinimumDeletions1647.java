package sort;

import java.util.*;

public class MinimumDeletions1647 {

//    public int minDeletions(String s) {
//        int res = 0;
//        int[] frequency = getFrequency(s);
//        Map<Integer, Integer> map = new HashMap<>();
//        List<sort.rank.Word> list = new ArrayList<>();
//        for (int i = 0; i < frequency.length; i++) {
//            if(frequency[i] == 0) {
//                continue;
//            }
//            list.add(new Word(i, frequency[i]));
//            map.put(frequency[i], map.getOrDefault(frequency[i], 0) + 1);
//        }
//        Collections.sort(list, (w1, w2)->w2.c - w1.c);
//        for (sort.rank.Word w : list) {
//            int f = w.c;
//            if(map.get(f) > 1) {
//                int nextFNotOccur = findNextNotOccur(f, map);
//                map.put(f, map.get(f) - 1);
//                map.put(nextFNotOccur, 1);
//                res += (f - nextFNotOccur);
//            }
//        }
//        return res;
//    }
//
//    private int[] getFrequency(String s) {
//        int[] arr = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            arr[ch - 'a'] += 1;
//        }
//        return arr;
//    }
//
//    private int findNextNotOccur(int f, Map<Integer, Integer> map) {
//        while (map.get(f) != null) {
//            f--;
//        }
//        return f;
//    }
}
