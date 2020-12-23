package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[][] reachableTable = new int[n][n];
        Map<Integer, List<Integer>> map = getPrerequisiteMap(prerequisites, reachableTable);
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int curCourse = queries[i][1];
            res.add(dfs(curCourse, queries[i][0], map, reachableTable));
        }
        return res;
    }
    boolean dfs(int sourceCourse, int destinationCourse, Map<Integer, List<Integer>> map, int[][] reachableTable){
        List<Integer> preCourse = map.get(sourceCourse);
        if (preCourse == null || preCourse.size() == 0) {
            reachableTable[sourceCourse][destinationCourse] = 2;
            return false;
        }
        if (reachableTable[sourceCourse][destinationCourse] == 1) {
            return true;
        }
        if (reachableTable[sourceCourse][destinationCourse] == 2) {
            return false;
        }
        if (preCourse.contains(destinationCourse)) {
            reachableTable[sourceCourse][destinationCourse] = 1;
            return true;
        }
        for (Integer pre : preCourse) {
            boolean isReachable = dfs(pre, destinationCourse, map, reachableTable);
            if (isReachable) {
                reachableTable[pre][destinationCourse] = 1;
                return true;
            }
        }
        reachableTable[sourceCourse][destinationCourse] =2;
        return false;
    }

    Map<Integer, List<Integer>> getPrerequisiteMap(int[][] prerequisites, int[][] reachableTable){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int curCourse = prerequisites[i][1];
            int preCourse = prerequisites[i][0];
            reachableTable[curCourse][preCourse] = 1;
            List<Integer> prerequisiteList = map.getOrDefault(curCourse, new ArrayList<>());
            prerequisiteList.add(preCourse);
            map.put(curCourse, prerequisiteList);
        }
        return map;
    }
    @Test
    public void test(){
        int[][] courses = {{2,3},{2,1},{2,0},{3,4},{3,6},{5,1},{5,0},{1,4},{1,0},{4,0},{0,6}};
        List<Boolean> res = checkIfPrerequisite(7, courses, new int[][]{{3, 0}, {5,6}});
    }
}
