package oa.amazon.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
//skyline classical algorithm
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        List<EndPoint> points = new ArrayList<>();
        for (int[] interval : intervals) {
            EndPoint start = new EndPoint(interval[0], 1);
            EndPoint end = new EndPoint(interval[1], -1);
            points.add(start);
            points.add(end);
        }
        Collections.sort(points, (o1, o2)->o1.point == o2.point ? o1.count - o2.count : o1.point - o2.point);
        int maxCount = 0;
        int count = 0;
        for (EndPoint point : points) {
            count += point.count;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
    public int minMeetingRooms_1(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->a[1] - b[1]);
        int count = 0;
        for (int[] interval : intervals) {
            if (queue.isEmpty()) {
                queue.offer(interval);
                continue;
            }
            if (interval[0] >= queue.peek()[1]) {
                count = Math.max(count, queue.size());
                queue.poll();
            }
            queue.offer(interval);

        }
        return Math.max(count, queue.size());
    }
}

class EndPoint{
    int point;
    int count;
    EndPoint(){}
    EndPoint(int point, int count){
        this.point = point;
        this.count = count;
    }
}
