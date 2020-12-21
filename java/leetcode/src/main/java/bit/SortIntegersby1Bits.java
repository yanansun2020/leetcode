package bit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortIntegersby1Bits {
    public int[] sortByBits(int[] arr) {
        List<NumAndBits> tmpList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int numOfBots = getNumOfBits(arr[i]);
            NumAndBits numAndBits = new NumAndBits(arr[i], numOfBots);
            tmpList.add(numAndBits);
        }
        Collections.sort(tmpList, (o1, o2) -> {
            if (o1.numOfBits == o2.numOfBits) {
                return o1.num - o2.num;
            }
            return o1.numOfBits - o2.numOfBits;
        });
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = tmpList.get(i).num;
        }
        return ans;
    }

    int getNumOfBits(int num) {
        int count = 0;
        if (num == 0) {
            return count;
        }
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num >>>= 1;
        }
        return count;
    }

    int countSetBits(int num){
        int counter=0;
        while(num>0){
            num = num & (num-1);
            counter++;
        }
        return counter;
    }
}

class NumAndBits {
    int num;
    int numOfBits;

    NumAndBits(int num, int numOfBits) {
        this.num = num;
        this.numOfBits = numOfBits;
    }
}

