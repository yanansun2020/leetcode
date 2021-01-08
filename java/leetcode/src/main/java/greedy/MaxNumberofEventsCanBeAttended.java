package greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Intuitively we tend to do work that finished in early time
 * SO sort the array by endtime
 */
public class MaxNumberofEventsCanBeAttended {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b)->a[1]==b[1]? a[0] - b[0] :a[1]-b[1]);
        int[] daySlot = new int[100001];
        int ans = 0;
        for (int i = 0; i < events.length; i++) {
            int firstAvailableDay = findFirstAvailableDay(events[i][0], events[i][1], daySlot);
            if (firstAvailableDay != -1) {
                ans++;
                daySlot[firstAvailableDay] = 1;
            }
        }
        return ans;
    }
    int findFirstAvailableDay(int start, int end, int[] daySlot) {
        int left = start;
        int right = end;
        if (daySlot[start] == 0) {
            return start;
        }
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (daySlot[mid] == 0) {
                if (daySlot[mid-1] == 1) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        left = Math.min(left, end);
        return daySlot[left] == 0 ? left : -1;
    }
    @Test
    public void test(){
        int[][] events = new int[][]{{1,5},{1,5},{1,5},{2,3},{2,3}};
        int ans = maxEvents(events);
    }
}
