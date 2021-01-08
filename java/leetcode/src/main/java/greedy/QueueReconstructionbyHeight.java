package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 利用comparetor对数组进行排序，然后将数组插入到k值所在的位置。
 */
public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2)->o2[0] == o1[0]? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> ans = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            ans.add(people[i][1], people[i]);
        }
        return ans.toArray(new int[people.length][2]);
    }
}
