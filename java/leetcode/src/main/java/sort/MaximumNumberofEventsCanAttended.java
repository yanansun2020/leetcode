package sort;

import algorithm.tree.SegTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumNumberofEventsCanAttended {
    public int maxEvents(int[][] events) {
        if (events == null || events.length == 0) {
            return 0;
        }

        List<int[]> eventList = new ArrayList<>();
        int lastDay = Integer.MIN_VALUE;
        for (int[] event: events) {
            lastDay = Math.max(lastDay, event[1]);
            eventList.add(event);
        }

        Collections.sort(eventList, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });


        SegTree sg = new SegTree(lastDay);
        int count = 0;
        for (int[] event: eventList) {
            int earliestDay = sg.getRangeQuery(event[0], event[1]);
            if (earliestDay != Integer.MAX_VALUE) {
                count++;
                sg.update(earliestDay);
            }
        }

        return count;
    }
    @Test
    public void test(){
        int[][] events = new int[][]{{1,2},{2,3},{3,4}};
        int maxEvent = maxEvents(events);
        events = new int[][]{{1,2},{2,3},{3,4},{1,2}};
        maxEvent = maxEvents(events);
        events = new int[][]{{1,4},{4,4},{2,2},{3,4},{1,1}};
        maxEvent = maxEvents(events);
        events = new int[][]{{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}};
        maxEvent = maxEvents(events);
        events = new int[][]{{1, 1000}};
        maxEvent = maxEvents(events);
    }
}
