package oa.gg;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 给了一个数组，at most k variant sorted. 意思就是一个数，如果按排好了序，
 * 位置应该在 N，那么他现在的位置就可能在 N到N + K的范围内。
 * 要求将这个数组再排序。我的解法是用一个K capacity的priorityQueue就可以了。
 */
public class VariantSort {
    private static void kSort(int[] arr, int n, int k)
    {
 
        // min heap
        PriorityQueue<Integer> priorityQueue
            = new PriorityQueue<>();
 
        // add first k + 1 items to the min heap
        for (int i = 0; i < k + 1; i++) {
            priorityQueue.add(arr[i]);
        }
 
        int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }
 
        Iterator<Integer> itr = priorityQueue.iterator();
 
        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    }
 
    // A utility function to print the array
    private static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        // int k = 3;
        // int arr[] = { 2, 6, 3, 12, 56, 8 };
        int k = 2;
        int[] arr = {6, 5, 3,2,8, 10, 9}; 
        int n = arr.length;
        kSort(arr, n, k);
        System.out.println("Following is sorted array");
        printArray(arr, n);
    }
}
