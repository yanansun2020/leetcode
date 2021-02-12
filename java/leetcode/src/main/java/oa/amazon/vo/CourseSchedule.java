package oa.amazon.vo;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> requisiteMap = getPreRequisiteCourses(prerequisites);
        int[] inDegree = buildDegree(numCourses, prerequisites);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            count++;
            List<Integer> neighbors = requisiteMap.get(cur);
            if (neighbors != null && neighbors.size() > 0) {
                for (Integer neighbor : neighbors) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return count == numCourses;
    }



    public boolean canFinish_1(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> requisiteMap = getPreRequisiteCourses(prerequisites);
        int[] visited = new int[numCourses];
        for (int i = 1; i < numCourses; i++) {
            if (!dfs(i, visited, requisiteMap)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int num, int[] visited, Map<Integer, List<Integer>> requisiteMap){
        if (visited[num] == 2) {
            return true;
        }
        if (visited[num] == 1) {
            return false;
        }
        visited[num] = 1;
        List<Integer> preCourses = requisiteMap.get(num);
        if (preCourses != null && preCourses.size() > 0) {
            for (Integer preCourse : preCourses) {
                if (!dfs(preCourse, visited, requisiteMap)){
                    return false;
                }
            }
        }
        visited[num] = 2;
        return true;
    }
    Map<Integer, List<Integer>> getPreRequisiteCourses(int[][] prerequisites){
        Map<Integer, List<Integer>> prerequisitesMap = new HashMap<>();
        for (int[] re : prerequisites) {
            List<Integer> prerequisitesCourse = prerequisitesMap.getOrDefault(re[1], new ArrayList<>());
            prerequisitesCourse.add(re[0]);
            prerequisitesMap.put(re[1], prerequisitesCourse);
        }
        return prerequisitesMap;
    }

    int[] buildDegree(int n, int[][] prerequisites) {
        int[] inDegree = new int[n];
        for (int[] required : prerequisites) {
            inDegree[required[0]]++;
        }
        return inDegree;
    }
}
