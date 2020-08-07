package array;

import java.util.Map;
import java.util.TreeMap;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int[] trip: trips){
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0] );
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0] );
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry:  map.entrySet()){
            count += entry.getValue();
            if (count > capacity){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        CarPooling test = new CarPooling();
        int[][] trips = {{2,1,5}, {3,3,7}};
        System.out.println(test.carPooling(trips, 5));
    }
}