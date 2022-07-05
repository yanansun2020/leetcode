package oa.ms;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dominos {
    public String missingTile(List<String> list) {
        Set<String> set = new HashSet<>();
        for (String s : list) {
            String reversedTile = s.charAt(2) + "-" + s.charAt(0);
            set.add(s);
            set.add(reversedTile);
        }
        String res = "";
        for(int i = 0; i <= 6; i++){
            for(int j = 0; j <= 6; j++){

                String tile = i + "-" + j;

                if(!set.contains(tile)){
                    res = tile;
                    break ;
                }
            }
        }

        return res;
    }
    @Test
    public void test() {

    }
}
