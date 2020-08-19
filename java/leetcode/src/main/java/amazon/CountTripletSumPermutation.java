package amazon;

public class CountTripletSumPermutation {
    int count(int size, int[] arr, int tripleSum){
        int count = 0;
        for(int i =0; i<size-2; i++){
            if(tripleSum% arr[i] == 0){
                for(int j = i+1; j<size-1; j++){
                    if(tripleSum%(arr[i] * arr[j]) == 0){
                        int value = tripleSum/(arr[i] * arr[j]);
                        for(int k=j+1; k < size; k++){
                            if (arr[k] == value){
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
