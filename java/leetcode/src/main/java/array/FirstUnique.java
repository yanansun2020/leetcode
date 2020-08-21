package array;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * important: LinkedHashSet
 */
public class FirstUnique {
    Map<Integer, Integer> freMap;
    Set<Integer> nodeList;
    public FirstUnique(int[] nums) {
        freMap = new HashMap<>();
        nodeList = new LinkedHashSet<>();
        for(int num : nums){
            add(num);
        }
    }

    public int showFirstUnique() {
        if (nodeList.isEmpty()){
            return -1;
        }
        Integer head = nodeList.iterator().next();
        return head == null ? -1 : head;
    }

    public void add(int value) {
        Integer node = freMap.get(value);
        if(node == null){
            //node = new FrequencyNode(value, 1);
            nodeList.add(value);
            freMap.put(value, value);
        }else{
            if(nodeList.contains(value)){
//                int index = nodeList.indexOf(value);
                nodeList.remove(value);
            }
            //freMap.remove(value);
        }
    }
    public static void main(String[] args){
        FirstUnique firstUnique = new FirstUnique(new int[]{2,3,5});
        int a = firstUnique.showFirstUnique();
        firstUnique.add(5);
        int b = firstUnique.showFirstUnique();
        firstUnique.add(2);
        int c = firstUnique.showFirstUnique();
        firstUnique.add(3);
        int d = firstUnique.showFirstUnique();

//        FirstUnique firstUnique = new FirstUnique(new int[]{2});
//        firstUnique.add(2);
//        firstUnique.add(2);
//        int a = firstUnique.showFirstUnique();
    }
}

class FrequencyNode{
    int value;
    int frequency;
    FrequencyNode(int value, int frequency){
        this.value = value;
        this.frequency = frequency;
    }
}
