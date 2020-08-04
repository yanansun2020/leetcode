package string;

import org.junit.Test;

public class SimilarStringGroups {
    public int numSimilarGroups(String[] A) {
        int[] parents = new int[A.length];
        int[] ranks = new int[A.length];
        for (int i =0; i< A.length; i++){
            parents[i] = i;
        }
        for (int i =0; i<A.length; i++){
            for (int j =0; j < i; j++){
                if(isSimilar(A[i], A[j])){
                    union(i, j, ranks, parents);
                }
            }
        }
        int count = 0;
        for(int index = 0; index<parents.length; index++){
            if(parents[index] == index ){
                count ++;
            }
        }
        return count;
    }
    public void union(int i, int j, int[] ranks, int[] parents){
        int parent_i = find(i, parents);
        int parent_j = find(j, parents);
        if(parent_i != parent_j){
            int rank_i = ranks[parent_i];
            int ranks_j = ranks[parent_j];
            if (rank_i == ranks_j){
                parents[i] = parent_j;
                parents[parent_i] = parent_j;
                ranks[j] ++;
            }else if (rank_i > ranks_j){
                parents[j] = parent_i;
                parents[parent_j] = parent_i;
            }else{
                parents[i] = parent_j;
                parents[parent_i] = parent_j;
            }
        }
    }
    public int find(int index, int[] parents){
        if (parents[index] == index){
            return index;
        }
        int parent_ = find(parents[index], parents);
        parents[index] = parent_;
        return parent_;
    }
    public boolean isSimilar(String x, String y){
        int difference = 0;
        for(int i =0; i<x.length(); i++){
            if(x.charAt(i) != y.charAt(i)){
                if(difference == 2){
                    return false;
                }
                difference++;
            }
        }
        return true;
    }

    @Test
    public void test(){
        String[] aa = {"ajdidocuyh","djdyaohuic","ddjyhuicoa","djdhaoyuic","ddjoiuycha","ddhoiuycja","ajdydocuih","ddjiouycha","ajdydohuic"};
       int result = numSimilarGroups(aa);
    }
}
