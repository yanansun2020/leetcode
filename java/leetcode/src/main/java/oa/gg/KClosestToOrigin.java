package oa.gg;

import java.util.*;

/**
 * quick select
 * priority queue
 */
public class KClosestToOrigin {
    public int[][] getKClosest(int[][] points, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[] distance = getDistance(points, map);
        List<int[]> res = new ArrayList<>();
        quickSelect(distance, res, k, 0, distance.length, map);
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    void quickSelect(int[] distance, List<int[]> res, int k, int left, int right, Map<Integer, List<int[]>> map) {
        int index = partition(distance,left, right);
        if (index < k) {
            for (int i = left; i <= index; i++) {
                res.addAll(map.get(distance[i]));
            }
            quickSelect(distance, res, k, left + 1, right, map);
        } else if (index > k) {
            quickSelect(distance, res, k, left, right - 1, map);
        } else {
            return;
        }
    }

    int partition(int[] distance, int left, int right) {
        int pivot = getPivot(distance, left, right);
        int i = left, j = right;
        while (i < j) {
            do{
                i++;
            } while(i < j && i < distance.length && distance[i] < pivot);

            do{
                j--;
            }while(j > i && j >= 0 && distance[j] > pivot);

            if (i < j) {
                swap(distance, i, j);
            }
        }
        swap(distance, left, j);
        return j;
    }

    private int getPivot(int[] dis, int left, int right) {
        int mid = left + (right - left)/2;
        swap(dis, left, mid);
        return dis[left];
    }

    private void swap(int[] dis, int i, int j) {
        int tmp = dis[i];
        dis[i] = dis[j];
        dis[j] = tmp;
    }

    public int[] getDistance(int[][] points, Map<Integer, List<int[]>> map) {
        int[] distance = new int[points.length];
        for (int i = 0;  i < points.length; i++) {
            int[] point = points[i];
            int dis = point[0] * point[0] + point[1] * point[1];
            distance[i] = dis;
            map.putIfAbsent(dis, new ArrayList<>());
            map.get(dis).add(point);
        }
        return distance;
    }

////below from discussions
    public int[][] kClosest(int[][] points, int K) {
        int i = 0, j = points.length - 1;
        while(i < j) {
            int mid = partition(points, i, j);
            if(mid == K) break;
            if(mid < K) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return Arrays.copyOf(points, K);
    }

    private int partition(int[][] points, int start, int end) {
        int[] pivot = points[end];
        int swapIndex = start - 1;
        for(int i = start; i < end; i++) {
            if(value(points[i]) < value(pivot)) {
                swapIndex++;
                swap(points, swapIndex, i);
            }
        }
        swap(points, ++swapIndex, end);
        return swapIndex;
    }

    private int value(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }


}
