package oa.amazon.oa2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongPick {
    PairInt IdsOfSongs(int rideDuration, int numSongs, List<Integer> songDuration){
        Map<Integer, Integer> durationIndexMap = new HashMap<>();
        int target = rideDuration - 30;
        for(int i=0; i<numSongs; i++){
            int cur = songDuration.get(i);
            if(durationIndexMap.containsKey(target-cur)){
                return new PairInt(i, durationIndexMap.get(target-cur));
            }
            durationIndexMap.put(cur, i);
        }
        return new PairInt(-1, -1);
    }

    PairInt IdsOfSongs2(int rideDuration, int numSongs, List<Integer> songDuration){
        int target = rideDuration -30;
        Collections.sort(songDuration);
        int l = 0;
        int r = numSongs-1;
        while(l < r){
            if (songDuration.get(l) + songDuration.get(r) == target){
                return new PairInt(l, r);
            }
        }
        return new PairInt(-1, -1);
    }
    @Test
    public void test(){
        Integer[] array = {1,10,25,35, 60};
        List<Integer> aa = Arrays.asList(array);
        PairInt ss = IdsOfSongs(90, 5, aa);
    }
}

