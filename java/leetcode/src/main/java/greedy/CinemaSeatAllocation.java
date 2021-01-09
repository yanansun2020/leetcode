package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bit manipulation
 */
public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> reserveMap = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            int reservedRow = reservedSeats[i][0];
            Integer reserevedCols = reserveMap.getOrDefault(reservedRow, 0);
            reserevedCols |= (1 << reservedSeats[i][1]);
            reserveMap.put(reservedRow, reserevedCols);
        }
        int total = 0;
        for (Map.Entry<Integer,Integer> entry : reserveMap.entrySet()){
            int count = 0;
            Integer reservedCol = reserveMap.get(entry.getKey());
            if (reservedCol == null) {
                count = 2;
            } else {
                if ((reservedCol & 60) == 0) {
                    count++;
                }
                if ((reservedCol & 960) == 0) {
                    count++;
                }
                if (count == 0 && (reservedCol & 240) == 0) {
                    count++;
                }
            }

            total += count;
        }
        return total + 2 * (n - reserveMap.size());

    }
    public int maxNumberOfFamilies_TLE(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> reserveMap = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            int reservedRow = reservedSeats[i][0];
            int reservedCol = reservedSeats[i][1];
            List<Integer> reserevedCols = reserveMap.getOrDefault(reservedRow, new ArrayList<Integer>());
            reserevedCols.add(reservedCol);
            reserveMap.put(reservedRow, reserevedCols);
        }
        int total = 0;
        for (Map.Entry<Integer, List<Integer>> entry : reserveMap.entrySet()) {
            List<Integer> revervedCols = reserveMap.get(entry.getKey());
            if (revervedCols == null || revervedCols.size() == 0) {
                total += 2;
            } else {
                total += getGroup(revervedCols);
            }
        }
        return total + 2 * (n - reserveMap.size());
    }
    int getGroup(List<Integer> revervedCols){
        int iniGroup = 2;
        for (int i = 2; i<=5; i++){
            if (revervedCols.contains(i)) {
                iniGroup--;
                break;
            }
        }
        for (int i = 6; i <= 9; i++) {
            if (revervedCols.contains(i)) {
                iniGroup--;
                break;
            }
        }
        if (midavailable(revervedCols) && iniGroup == 0) {
            iniGroup++;
        }

        return Math.min(iniGroup, 2);
    }
    private boolean midavailable(List<Integer> revervedCols){
        for (int i = 4; i <= 7; i++) {
            if (revervedCols.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
