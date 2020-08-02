package contest;

import org.junit.Assert;
import org.junit.Test;

public class MinimumSwapstoArrangeaBinaryGrid {
    public int minSwaps(int[][] grid) {
        int count = 0;
        for(int i =0; i < grid.length; i++){
            int zerosInneed = grid.length - i -1;
            if(!enoughZeros(grid[i], zerosInneed)){
                //find rows with enough zeros
                int row = findMinRowWithEnoughzeros(i+1, grid.length, zerosInneed, grid);
                if(row == -1){
                    return -1;
                }
                swapByRow(i, row, grid);
                count += row - i;
            }
        }
        return count;
    }
    private void swapByRow(int start, int end, int[][] grid){
        int[] tmp = grid[end];
        for(int i = end; i > start; i--){
            grid[i] = grid[i-1];
        }
        grid[start] = tmp;
    }

    private int findMinRowWithEnoughzeros(int startRow, int length, int need_zeros, int[][] grid) {
        while(startRow < length){
            if(enoughZeros(grid[startRow], need_zeros)){
                return startRow;
            }
            startRow ++;
        }
        return -1;
    }

    private boolean enoughZeros(int[] ints, int zeros_in_need) {
        int count_zero = getZeroNumber(ints);
        return count_zero >= zeros_in_need;
    }
    private int getZeroNumber(int[] ints) {
        int count_zero = 0;
        for(int j =ints.length-1; j > 0; j--){
            if(ints[j] == 0){
                count_zero++;
                continue;
            }
            break;
        }
        return count_zero;
    }

    @Test
    public void test1(){
        int[][] array = {{0,0,1},{1,1,0},{1,0,0}};
        Assert.assertTrue(minSwaps(array) == 3);;
        int[][] array_1  ={{0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0}};
        Assert.assertTrue(minSwaps(array_1) == -1);
        int[][] array_2  ={{1,0,0},{1,1,0},{1,1,1}};
        Assert.assertTrue(minSwaps(array_2) == 0);
    }
}
