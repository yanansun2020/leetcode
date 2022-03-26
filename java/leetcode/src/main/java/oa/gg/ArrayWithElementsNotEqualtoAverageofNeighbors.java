package oa.gg;

import java.util.Arrays;

/**
 * 给一组数 不重复的
 * 要你generate一个permutation
 * 满足每两个数之间不出现他们的平均数
 * 比如234就不行 因为中间出现了3
 * 我是想了一个helper function，每次加一个数的时候就看看能不能加进去，能加就继续helper function，不能加就把现在的数组最‍‌‍‌‌‌‌‌‌‌‍‌‌‌‍‌‍‍‌‌后一个挪走了
 * 这个大哥觉得不行
 * 非常迷茫…
 *
 *
 * idea2:
 * 如果一组数是 2 3 4，那么我们只需要准备一个大顶堆和小顶堆，将所有数字都加入到这两个堆中。
 * 紧接着我们不断依次弹出小数字，大数字，小数字，大数字。。那么最终的答案就是 2 4 3，也就满足要求了。
 */
public class ArrayWithElementsNotEqualtoAverageofNeighbors {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1;i< nums.length-1;i+=2){
            swap(nums,i,i+1);
        }
        return nums;
    }
    public void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }
}
