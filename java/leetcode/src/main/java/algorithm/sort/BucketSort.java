package algorithm.sort;

import java.util.Collections;
import java.util.Vector;

/**
 * bucketSort(arr[], n)
 * 1) Create n empty buckets (Or lists).
 * 2) Do following for every array element arr[i].
 * .......a) Insert arr[i] into bucket[n*array[i]]
 * 3) Sort individual buckets using insertion sort.
 * 4) Concatenate all sorted buckets.
 */
public class BucketSort {
    static void bucketSort(float arr[], int n)
    {
        if (n <= 0)
            return;

        // 1) Create n empty buckets
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new Vector<Float>();
        }

        // 2) Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            float idx = arr[i] * n;
            buckets[(int)idx].add(arr[i]);
        }

        // 3) Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
}
