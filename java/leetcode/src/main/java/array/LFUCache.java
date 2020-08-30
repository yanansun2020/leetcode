package array;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    KeyNode head;
    KeyNode tail;
    Map<Integer, KeyNode> map;
    int capacity;
    public LFUCache(int capacity) {
        head = new KeyNode(-1, -1);
        tail = new KeyNode(-1,-1);
        head.next =tail;
        tail.pre = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        KeyNode keyNode = map.get(key);
        remove(keyNode);
        keyNode.frequency+=1;
        add(keyNode);
        return keyNode.value;
    }
    public void put(int key, int value) {
        KeyNode keyNode = map.get(key);
        if(keyNode != null){
            remove(keyNode);
            map.remove(keyNode.key);
        }else{
            keyNode = new KeyNode(key, value);
        }
        if(map.size() == capacity){
            KeyNode keyNodeRemove = tail.pre;
            remove(keyNodeRemove);
            map.remove(keyNodeRemove.key);
        }
        keyNode.frequency += 1;
        keyNode.value = value;
        add(keyNode);
        map.put(key, keyNode);

    }
    public void remove(KeyNode keyNode){
        KeyNode previous = keyNode.pre;
        KeyNode next = keyNode.next;
        previous.next = next;
        next.pre = previous;
    }
    public void add(KeyNode keyNode){
        KeyNode tmpKeyNode = head.next;
        while(tmpKeyNode.frequency > keyNode.frequency){
            tmpKeyNode = tmpKeyNode.next;
        }
        KeyNode previous = tmpKeyNode.pre;
        previous.next = keyNode;
        keyNode.pre = previous;
        keyNode.next = tmpKeyNode;
        tmpKeyNode.pre = keyNode;
    }
//    @Test
    public static void main(String[] args){
        LFUCache cache = new LFUCache(2);
//        cache.put(1,1);
//        cache.put(2,2);
//        int a = cache.get(1);
//        cache.put(3,3);
//        int b = cache.get(2);
//        int b1 = cache.get(3);
//        cache.put(4,4);
//        int c = cache.get(1);
//        int d = cache.get(3);
//        int e = cache.get(4);
        /*cache.put(3,1);
        cache.put(2,1);
        cache.put(2,2);
        cache.put(4,4);
        int a = cache.get(2);*/
        int a = cache.get(2);
        cache.put(2,6);
        int b = cache.get(1);
        cache.put(1,5);
        cache.put(1,2);
        int c = cache.get(1);
        int d = cache.get(2);
    }
}
class KeyNode {
    int key;
    int value;
    int frequency;
    KeyNode pre;
    KeyNode next;
    KeyNode(){}
    KeyNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}
