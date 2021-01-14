package backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupthePeopleGiventheGroupSize {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = getGroupMap(groupSizes);
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int groupSize = entry.getKey();
            List<Integer> peopleInGroup = entry.getValue();
            List<Integer> g = new ArrayList<>();
            for (int i = 0; i < peopleInGroup.size(); i++) {
                if (i % groupSize == 0 && i != 0) {
                    ans.add(new ArrayList<>(g));
                    g = new ArrayList<>();
                }
                g.add(peopleInGroup.get(i));
            }
            ans.add(new ArrayList<>(g));
        }
        return ans;
    }
    Map<Integer, List<Integer>> getGroupMap(int[] groupSizes){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> people = map.getOrDefault(groupSizes[i], new ArrayList<>());
            people.add(i);
            map.put(groupSizes[i], people);
        }
        return map;
    }

    @Test
    public void test(){
        int[] group = new int[]{2,1,3,3,3,2};
        List<List<Integer>> ans = groupThePeople(group);
    }
}
