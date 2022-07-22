package oa.amazon.vo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * all paths from top left to bottom right
 * can only move to right and bottom
 *
 *  1 2 3
 *  4 5 6
 *  7 8 9
 */
public class MatrixPath {

    public List<List<Integer>> getMatrixPath(int[][] matrix) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(matrix, 0, 0, tmp, res);
        return res;
    }
    private void dfs(int[][] matrix, int i, int j, List<Integer> tmp, List<List<Integer>> res) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return;
        }
        tmp.add(matrix[i][j]);
        if(i == matrix.length - 1 && j == matrix[0].length -1) {
            res.add(new ArrayList<>(tmp));
            //return ahead, so need to remove the last element
            tmp.remove(tmp.size() - 1);
            return;
        }
        dfs(matrix, i, j + 1, tmp, res);
        dfs(matrix, i + 1, j, tmp, res);
        tmp.remove(tmp.size() - 1);
    }


    @Test
    public void test() {
//        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
//        List<List<Integer>> res = getMatrixPath(matrix);
//        System.out.println(res);
        int[][] matrix = new int[][]{{1,2}, {3,4}};
        List<List<Integer>> res = getMatrixPath(matrix);
        System.out.println(res);
    }

}
