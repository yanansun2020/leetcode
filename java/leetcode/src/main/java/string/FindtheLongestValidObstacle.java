package string;

import org.junit.Test;

import java.util.LinkedList;

public class FindtheLongestValidObstacle {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int length = obstacles.length;
        int[] ans = new int[length];
        ans[0] = 1;
        LinkedList<Pair> arr = new LinkedList<Pair>();
        arr.add(new Pair(obstacles[0], 1));
        for (int i = 1; i < obstacles.length; i++) {
            int num = obstacles[i];
            if (num >= arr.getLast().ele) {
                ans[i] = arr.getLast().num + 1;
                arr.add(new Pair(num, ans[i]));
            } else {
                int index = bisearch(arr, num);
                ans[i] = index + 1;
                arr.set(index, new Pair(num, ans[i]));
            }
        }
        return ans;
    }

    private int bisearch(LinkedList<Pair> list, int target) {
        System.out.println(list);
        System.out.println(target);
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = left + (right - left)/2;
            if (list.get(mid).ele <= target) {
                left = mid + 1;
            } else {
                right = mid ;
            }
        }
        return left;
    }

    @Test
    public void test() {
        int[] arr = new int[]{1,2,3,2};
        int[] ans = longestObstacleCourseAtEachPosition(arr);
    }
}

class Pair {
    int ele;
    int num;
    Pair(int ele, int num) {
        this.ele = ele;
        this.num = num;
    }
}
