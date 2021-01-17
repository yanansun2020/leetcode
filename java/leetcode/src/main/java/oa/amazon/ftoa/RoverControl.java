package oa.amazon.ftoa;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RoverControl {
    public static int roverMove(String[] cmnds, int n){
        int i = 0;
        int j = 0;
        Map<String, int[]> directionMap = new HashMap<>();
        directionMap.put("UP", new int[]{-1, 0});
        directionMap.put("DOWN", new int[]{1, 0});
        directionMap.put("LEFT", new int[]{0, -1});
        directionMap.put("RIGHT", new int[]{0, 1});

        for (String cmd : cmnds) {
            int[] direction = directionMap.get(cmd);
            int x = i + direction[0];
            int y = j + direction[1];
            if ( x < 0 || x > n - 1) {
                continue;
            }
            if (y < 0 || y > n - 1) {
                continue;
            }
            i = x;
            j = y;
        }
        return i * n + j;
    }

    @Test
    public void test(){
        String[] cms = new String[]{"RIGHT", "UP", "DOWN", "LEFT", "DOWN", "DOWN"};
        int ans = roverMove(cms, 4);
    }
}
