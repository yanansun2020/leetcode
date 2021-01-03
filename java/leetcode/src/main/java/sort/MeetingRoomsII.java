package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2)->o1[1] - o2[1]);
        queue.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (!isOverlap(queue.peek(), intervals[i])) {
                queue.poll();
            }
            queue.offer(intervals[i]);
        }
        return queue.size();

    }
    private boolean isOverlap(int[] i1, int[] i2){
        return i2[0] >= i1[0] && i2[0] < i1[1];
    }

    @Test
    public void test(){
        int[][] intervals = new int[][]{{0, 30},{5, 10},{15, 20}};
        int ans = minMeetingRooms(intervals);
        intervals = new int[][]{{9,10},{4,9},{4,17}};
        ans = minMeetingRooms(intervals);
    }
}
