package contest;

import org.junit.Test;

public class DetectPattern {
    public boolean containsPattern(int[] arr, int m, int k) {
        for(int i =0; i <=arr.length -m; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < i + m; j++){
                sb.append(arr[j]).append(",");
            }
            int tmpK = k;
            int factor = 1;
            tmpK--;
            while(tmpK > 0){
                StringBuilder sb1 = new StringBuilder();
                for(int j = i + factor * m; j < Math.min(i + (factor+1) * m, arr.length); j++){
                    sb1.append(arr[j]).append(",");
                }
                if(sb1.toString().equals(sb.toString())){
                    tmpK--;
                    if(tmpK == 0){
                        return true;
                    }
                    factor++;
                }else{
                    break;
                }
            }

        }
        return false;
    }
    @Test
    public void test(){
        boolean ans0 = containsPattern(new int[]{1,2,4,4,4,4}, 1,3);
        boolean ans = containsPattern(new int[]{1,2,3,1,2}, 2,2);
        boolean ans1 = containsPattern(new int[]{1,2,1,2,1,1,1,3}, 2,2);
        boolean ans2 = containsPattern(new int[]{2,1,2,2,2,2,2,2}, 2,2);
        boolean ans3 = containsPattern(new int[]{3,2,1,3,3,2,1,3,3,1,2,3,3,2,1,3,2,1,1}, 1,2);
        boolean ans4 = containsPattern(new int[]{2,2,2,2}, 2,3);
        boolean ans5 = containsPattern(new int[]{2,1,2,2,2,2,2,2}, 2,2);
    }
}
class FreStartEnd{
    int fre;
    int start;
    int end;
    FreStartEnd(int fre, int start, int end){
        this.fre = fre;
        this.start = start;
        this.end = end;
    }
}
