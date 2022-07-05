package oa.ms;
//idea: keep swaping the adjancent element if the order is not correct
//each iteration will let at least one element on the right position
//after one iteration, the biggest will be on the right position

import org.junit.Test;

//in theory, we need n iteration to put all elements on the right position,
//but if some elements are already sorted, we may need less then n iterations
// the indicator of ending is no swap in one iteration
public class BubbleSort {
    public void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }


    private void print(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    @Test
    public void test() {
        int [] arr = {5, 1, 4, 2, 8};
        bubbleSort(arr);
        print(arr);
    }
}
