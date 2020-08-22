package robinhood;

public class Monotic {
    int[] checkMonotonicity(int[] arr) {
        int length = arr.length;
        int[] ans = new int[length-2];
        for(int i =0; i<length-2; i++){
            if((arr[i] > arr[i+1] && arr[i+1] > arr[i+2]) || (arr[i] < arr[i+1] && arr[i+1]< arr[i+2])){
                ans[i] = 1;
            }
        }
        return ans;
    }

}
