package greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reconstructa2RowBinaryMatrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2){
                ans.get(0).add(1);
                ans.get(1).add(1);
                upper--;
                lower--;
            } else if (colsum[i] == 1){
                if (upper > lower){
                    ans.get(0).add(1);
                    ans.get(1).add(0);
                    upper--;
                } else {
                    ans.get(0).add(0);
                    ans.get(1).add(1);
                    lower--;
                }
            } else {
                ans.get(0).add(0);
                ans.get(1).add(0);
            }
        }
        if(lower != 0 || upper != 0){
            return Collections.emptyList();
        }

        return ans;
    }
    @Test
    public void test(){
        int[] col = new int[]{1,1,1};
        List<List<Integer>> ans = reconstructMatrix(2,1,col );
        col = new int[]{2,2,1,1};
        ans = reconstructMatrix(2,3,col );
        col = new int[]{2,1,2,0,1,0,1,2,0,1};
        ans = reconstructMatrix(5,5,col );
    }
}
