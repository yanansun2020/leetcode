package sort;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SorttheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                int difference = i - j;
                LinkedList<Integer> disgonalValue = map.getOrDefault(difference, new LinkedList<>());
                disgonalValue.add(mat[i][j]);
            }
        }
        for (Map.Entry<Integer, LinkedList<Integer>> entry: map.entrySet()){
            Collections.sort(entry.getValue());
        }
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++ ){
            for (int j = 0; j < col; j++){
                int difference = i - j;
                LinkedList<Integer> disgonalList = map.get(difference);
                ans[i][j] = disgonalList.removeFirst();
            }
        }
        return ans;
    }

}
