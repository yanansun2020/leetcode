package algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class ListToArray {
    public int removeBoxes(int[] boxes) {
        if (boxes.length == 1) {
            return 1;
        }
        int global_max = 0;
        for (int i = 0; i < boxes.length;) {
            int j = i;
            int cur = boxes[i];
            while (j < boxes.length && boxes[j] == cur) {
                j++;
            }
            int size = j - i;
            int[] remainBox = getRemainBox(boxes, i, j);
            int local_max = size * size + removeBoxes(remainBox);
            i = j;
            global_max = Math.max(global_max, local_max);
        }
        return global_max;
    }

    private int[] getRemainBox(int[] box, int i, int j) {
        List<Integer> list = new ArrayList<>();
        for (int k = 0; k < i; k++) {
            list.add(box[k]);
        }
        for (int k = j; k < box.length; k++) {
            list.add(box[k]);
        }
        //Long[] array = (Long[]) list.toArray(new Long[list.size()]);
        int[] arr = new int[list.size()];
        int k = 0;
        for (Integer l : list) {
            arr[k++] = l;
        }

        return arr;
    }
}
