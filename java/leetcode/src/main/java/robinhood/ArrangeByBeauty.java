package robinhood;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ArrangeByBeauty {
    int[][] sortByBeauty(int[][] numbers, int size) {
        List<int[][]> topLeftPoints = new ArrayList<>();
        int rows = numbers.length;
        int cols = numbers[0].length;
        for(int i =0; i<rows; i+=size){
            for(int j = 0; j < cols; j+=size){
                int[][] subMatrix = new int[size][size];
                for(int k =0; k<size; k++){
                    for(int m=0; m <size; m++){
                        subMatrix[k][m] =numbers[i+k][j+m];
                    }
                }
                topLeftPoints.add(subMatrix);
            }
        }
        TreeMap<Integer, int[][]> treeMap = new TreeMap<>((o1, o2)->o1.compareTo(o2));
        for(int[][] points : topLeftPoints){
            int beauty = getBeauty(points);
            treeMap.put(beauty, points);
        }

        return null;
    }
    int getBeauty(int[][] points){
        List<Integer> lst = new ArrayList<>();
        for(int i =0; i<points.length; i++){
            for(int j = 0; j <points[0].length;j++){
                lst.add(points[i][j]);
            }
        }
        lst.sort(((o1, o2) -> o1.compareTo(o2)));
        for(int i =1; i<=lst.size(); i++){
            if(lst.get(i-1) != i){
                return i;
            }
        }
        return lst.size()+1;
    }
    @Test
    public void test(){
        int[][] matrix = new int[4][4];
        for(int i =1; i<=4; i++){
            for(int j =1; j<=4; j++){
                matrix[i-1][j-1] = i * j;
            }
        }
        sortByBeauty(matrix, 2);
    }

}
