package sort;

import java.util.Arrays;
import java.util.List;

public class MeetingScheduler1229 {
    public void minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (s1, s2)->s1[0] == s2[0] ? s1[1] - s2[1] : s1[0] - s2[0]);
        Arrays.sort(slots2, (s1, s2)->s1[0] == s2[0] ? s1[1] - s2[1] : s1[0] - s2[0]);

        int i = 0, j = 0;
    }
}
