package oa.gg;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目是给两个由0到n-1数字组成的数组，每次只能swap 0和其他数字，使得第一个数组最终变成第二个数组。刚开始我用时间O(n^2)，
 * 空间O(1)的复杂度做出，后来根据面试官的要求改成了时间空间都为O(n)的方法。
 *
 * 用一个hashmap存数字和index的对应关系。遍历每一个位置，每次都把0换到这个位置上，再把0跟target位置的数字交换就行了
 */
public class MatchSecondArray {
    public void match(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] correctPosition = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], i);
        }
        for (int i = 0; i < arr1.length; i++) {
            int indexOfZero = map.get(0);
            swap(i, indexOfZero, arr1, map);
            int indexOfCorrectValue = map.get(arr2[i]);
            swap(i, indexOfCorrectValue, arr1, map);
        }
    }

    private void swap(int index1, int index2, int[] arr, Map<Integer, Integer> map) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
        map.put(arr[index1], index1);
        map.put(arr[index2], index2);
    }

    @Test
    public void matchArray() {
        int[] arr1 = new int[]{1,2,3,0, 6, 5};
        int[] arr2 = new int[]{3,2,0, 1, 5, 6};
        match(arr1, arr2);
    }
}
