package unionfind;

import org.junit.Test;

import java.util.Arrays;

public class EveryoneBecomeFriends {
    public int earliestAcq(int[][] logs, int N) {
        UnionFind unionFind = new UnionFind(N);
        Arrays.sort(logs, (o1, o2)->o1[0] - o2[0]);
        for (int[] log : logs) {
            int time = log[0];
            int person1 = log[1];
            int person2 = log[2];
            boolean ifUnion = unionFind.union(person1, person2);
            if (ifUnion) {
                N--;
            }
            if (N == 1) {
                return time;
            }
        }
        return -1;
    }

    @Test
    public void test () {
        int[][] logs = new int[][]{{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        int time = earliestAcq(logs, 6);
    }
}
