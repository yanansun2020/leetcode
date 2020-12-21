package graph;
/**
 * topological sort
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> requisiteMap = getPreRequisiteCourses(prerequisites);
        List<Integer> finished = new ArrayList<>();
        Deque<Integer> orderedCourse = new LinkedList<>();
        int[] status = new int[numCourses];
        for (int i = numCourses - 1; i >= 0; i--) {
            if (finished.contains(i)) {
                continue;
            }
            if (!canFinish(i, requisiteMap, status, orderedCourse)){
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        int i = 0;
        while(!orderedCourse.isEmpty()){
            res[i++] = orderedCourse.pollFirst();
        }
        return res;
    }
    boolean canFinish(int course, Map<Integer, List<Integer>> requisiteMap, int[] status, Deque<Integer> orderedCourse){
        if(status[course] == 2) {
            return true;
        }
        if (status[course] == 1) {
            return false;
        }
        status[course] = 1;
        List<Integer> preCourses = requisiteMap.get(course);
        if (preCourses == null || preCourses.size() == 0) {
            orderedCourse.add(course);
            status[course] = 2;
            return true;
        }
        for (Integer preCourse : preCourses) {
            if (!canFinish(preCourse, requisiteMap, status, orderedCourse)){
                return false;
            }
        }
        orderedCourse.add(course);
        status[course] = 2;
        return true;
    }
    Map<Integer, List<Integer>> getPreRequisiteCourses(int[][] prerequisites){
        Map<Integer, List<Integer>> prerequisitesMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++ ) {
            int[] rows = prerequisites[i];
            int cur_course = rows[0];
            int prerequire = rows[1];
            List<Integer> prerequisitesCourse = prerequisitesMap.getOrDefault(cur_course, new ArrayList<>());
            prerequisitesCourse.add(prerequire);
            prerequisitesMap.put(cur_course, prerequisitesCourse);
        }
        return prerequisitesMap;
    }

    @Test
    public void test(){
        int[] res = findOrder(5, new int[][]{{1,0}, {2, 0}, {3,1}, {3,2}, {4,2}});
    }

}
