package graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * remove the course that takes longest time
 * Also can apply Priority queue
 */
public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (o1, o2)-> o1[1] - o2[1]);
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o2[0] - o1[0]));
        int curTotalTime = 0;
        for (int i = 0; i < courses.length; i++){
            int dur = courses[i][0];
            int closed_day = courses[i][1];
            curTotalTime += dur;
            queue.add(courses[i]);
            if (curTotalTime > closed_day) {
                int[] ele =queue.poll();
                curTotalTime -= ele[0];
            }
        }
        return queue.size();
    }

    @Test
    public void test(){
        int res = scheduleCourse(new int[][]{
            {5,5},{4,6},{2,6}});
         res = scheduleCourse(new int[][]{
            {5,15},{3,19},{6,7},{2,10},{5,16},{8,14},{10,11},{2,19}});
    }

}
