package algorithm.uf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
    public void test(){
        Map<String, List<String>> map = new HashMap<>();
        map.getOrDefault("name", new ArrayList<>());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {

        }
    }
}
