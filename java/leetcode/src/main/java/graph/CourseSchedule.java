package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> requisiteMap = getPreRequisiteCourses(prerequisites);
        List<Integer> finished = new ArrayList<>();
        for (int i = numCourses - 1; i >= 0; i--) {
            if (finished.contains(i)) {
                continue;
            }
            List<Integer> visited = new ArrayList<>();
            if (!canFinish(i, requisiteMap, visited, finished)){
                return false;
            }
        }
        return true;
    }

    boolean canFinish(int course, Map<Integer, List<Integer>> requisiteMap, List<Integer> visited, List<Integer> finished){
        if(finished.contains(course)) {
            return true;
        }
        if (visited.contains(course)) {
            return false;
        }
        visited.add(course);
        List<Integer> preCourses = requisiteMap.get(course);
        if (preCourses == null || preCourses.size() == 0) {
            finished.add(course);
            return true;
        }
        for (Integer preCourse : preCourses) {
            if (!canFinish(preCourse, requisiteMap, visited, finished)){
                return false;
            }
        }
        finished.add(course);
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
        canFinish(4, new int[][]{{1,0}, {2, 0}, {3,1}, {3,2}});
    }
}
