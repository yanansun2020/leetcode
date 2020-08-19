package amazon.oa2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TwoProducts {
    PairInt selectPackages(int truckSpace, int numPackages,
                           ArrayList<Integer> packagesSpace){
        Map<Integer, Integer> map = new HashMap<>();
        int target = truckSpace -30;
        int maxSize = Integer.MIN_VALUE;
        PairInt ans = null;
        for(int i =0; i<numPackages; i++ ){
            int left = target-packagesSpace.get(i);
            if(map.containsKey(left)){
                int tmpMax = Math.max(left,packagesSpace.get(i));
                if(tmpMax > maxSize){
                    ans = new PairInt(map.get(left), i);
                    maxSize = tmpMax;
                }
            }
            map.put(packagesSpace.get(i), i);
        }
        return ans;
    }

    PairInt select(int truckSpace, int numPackages,
                   ArrayList<Integer> packagesSpace){
        PairInt resPair = new PairInt(-1,-1);
        int target = truckSpace - 30, maxPkgSize = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<numPackages; i++ ){
            int remainSize = target-packagesSpace.get(i);
            if(map.containsKey(remainSize)){
                int tmpMax = Math.max(remainSize,packagesSpace.get(i));
                if(tmpMax > maxPkgSize){
                    maxPkgSize = tmpMax;
                    resPair.first = map.get(remainSize);
                    resPair.second = i;
                }
            }
        }
        return resPair;
    }
    @Test
    public void test(){
        ArrayList<Integer> array = new ArrayList<Integer>(){
            {
                add(1);
                add(10);
                add(25);
                add(35);
                add(60);
                add(59);
            }
        };
        PairInt ans = selectPackages(90, 6, array);
    }
}
