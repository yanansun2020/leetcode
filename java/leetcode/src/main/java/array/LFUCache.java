package array;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;
    public LFUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1,-1);
        head.next =tail;
        tail.pre = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        node.frequency+=1;
        add(node);
        return node.value;
    }
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            remove(node);
            map.remove(node.key);
        }else{
            node = new Node(key, value);
        }
        if(map.size() == capacity){
            Node nodeRemove = tail.pre;
            remove(nodeRemove);
            map.remove(nodeRemove.key);
        }
        node.frequency += 1;
        node.value = value;
        add(node);
        map.put(key, node);

    }
    public void remove(Node node){
        Node previous = node.pre;
        Node next = node.next;
        previous.next = next;
        next.pre = previous;
    }
    public void add(Node node){
        Node tmpNode = head.next;
        while(tmpNode.frequency > node.frequency){
            tmpNode = tmpNode.next;
        }
        Node previous = tmpNode.pre;
        previous.next = node;
        node.pre = previous;
        node.next = tmpNode;
        tmpNode.pre = node;
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
class Node{
    int key;
    int value;
    int frequency;
    Node pre;
    Node next;
    Node(){}
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
