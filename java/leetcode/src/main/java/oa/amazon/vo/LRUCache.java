package oa.amazon.vo;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    Map<Integer, Integer> map;
    LinkedList<Integer> list;
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        list = new LinkedList<Integer>();
    }

    public int get(int key) {
        if(map.containsKey(key)) {

        }
        return -1;
    }

    public void put(int key, int value) {

    }

    private void detachNode() {

    }
    @Test
    public void test(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(3);
        list.add(2);
//        boolean s = list.remove(2);

    }
}
