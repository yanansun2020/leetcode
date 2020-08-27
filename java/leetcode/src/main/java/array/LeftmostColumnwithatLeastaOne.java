package array;

import java.util.List;

public class LeftmostColumnwithatLeastaOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int rows = dim.get(0);
        int cols = dim.get(1);
        int pre1Col = -1;
        int i=0, j = cols-1;
        while(i <rows && j >=0){
            if(binaryMatrix.get(i, j) == 1){
                pre1Col = j;
                j--;
            }else{
                i++;
            }
        }
        return pre1Col;
    }
}
