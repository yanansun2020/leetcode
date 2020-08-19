package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (o1, o2)->o1[0]-o2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
        int globalCount = 1;
        for(int i =0; i<intervals.length; i++){
            if(queue.isEmpty()){
                queue.offer(intervals[i]);
                continue;
            }
            int[] topEle = queue.peek();
            if(intervals[i][0]>=topEle[1]){
                queue.poll();
            }
            queue.offer(intervals[i]);
            globalCount = Math.max(queue.size(), globalCount);
        }
        return globalCount;
        /*Arrays.sort(intervals, (o1, o2)->o1[0]-o2[0]);
        int globalCount = 1;
        int localCount = 1;
        int end = intervals[0][1];
        for(int i =1; i<intervals.length; i++){
            int start = intervals[i][0];
            if(start<end){
                localCount++;
                end = Math.min(intervals[i][1], end);
            }else{
                localCount = 1;
                end = intervals[i][1];
            }
            globalCount = Math.max(globalCount, localCount);
        }
        return globalCount;*/
    }
    @Test
    public void test(){
        int[][] array = {{0,30}, {15,20}, {5,10}};
        int room = minMeetingRooms(array);
        int[][] array1 = {{2,11}, {6,16}, {11,16}};
        int room1 = minMeetingRooms(array);
    }
}
