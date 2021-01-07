package sort;

import java.util.Map;
import java.util.TreeMap;

/**
 * 假如车B在车A的后面，而车B到终点线的时间小于等于车A，那么就知道车A和B一定会组成车队一起过线。
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int res = 0;
        Map<Integer, Float> treeMap = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < position.length; i++) {
            treeMap.put(position[i], (target - (float)position[i])/speed[i]);
        }
        float curtime = 0;
        int number = 0;
        for(Map.Entry<Integer, Float> entry:treeMap.entrySet()){
            float time = entry.getValue();
            if (time <= curtime) {
                continue;
            }
            number++;
            curtime = time;
        }
        return number;
    }
}
