package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class AllOne {
    /** Initialize your data structure here. */
    Map<String, FreNode> map;
    PriorityQueue<FreNode> minQueue;
    PriorityQueue<FreNode> maxQueue;
    public AllOne() {
        map = new HashMap<>();
        maxQueue = new PriorityQueue<>((o1, o2)->o2.fre.compareTo(o1.fre));
        minQueue = new PriorityQueue<>((o1, o2)->o1.fre.compareTo(o2.fre));
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        FreNode freNode = map.get(key);
        if(freNode == null){
            freNode = new FreNode(key, 1);
            minQueue.add(freNode);
            maxQueue.add(freNode);
        }else{
            minQueue.remove(freNode);
            maxQueue.remove(freNode);
            freNode.fre++;
            minQueue.add(freNode);
            maxQueue.add(freNode);
        }
        map.put(key, freNode);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!map.containsKey(key)){
            return;
        }
        FreNode freNode = map.get(key);
        if(freNode.fre == 1){
            map.remove(key);
            minQueue.remove(freNode);
            maxQueue.remove(freNode);
        }else{
            minQueue.remove(freNode);
            maxQueue.remove(freNode);
            freNode.fre--;
            minQueue.add(freNode);
            maxQueue.add(freNode);
            map.put(key, freNode);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return maxQueue == null || maxQueue.isEmpty()? "" :maxQueue.peek().key ;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return minQueue==null|| minQueue.isEmpty()? "" : minQueue.peek().key;
    }
    public static void main(String[] args){
        AllOne al = new AllOne();
        al.inc("a");
        al.inc("b");
        al.inc("a");
        al.inc("a");
        String s = al.getMaxKey();
        String s1 = al.getMinKey();
    }
}

class FreNode{
    String key;
    Integer fre;
    FreNode(String key, Integer fre){
        this.key = key;
        this.fre = fre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreNode freNode = (FreNode) o;
        return fre.equals(freNode.fre) &&
            Objects.equals(key, freNode.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, fre);
    }
}
