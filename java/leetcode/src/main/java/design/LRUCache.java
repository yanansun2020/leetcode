package design;

import java.util.HashMap;
import java.util.Map;

/**
 * double linked list + map
 */
public class LRUCache {
    Map<Integer, CacheNode> cacheMap;
    CacheNode header;
    CacheNode tail;
    int capacity;
    public LRUCache(int capacity) {
        cacheMap = new HashMap<>();
        header = new CacheNode();
        tail = new CacheNode();
        this.capacity = capacity;
    }

    public int get(int key) {
        CacheNode node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }
        detachNode(node);
        insertToFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        //first check if the key is already exist
        CacheNode node = cacheMap.get(key);
        if (node != null) {
            node.value = value;
            detachNode(node);
            insertToFirst(node);
            return;
        }
        //if the key is not in the cache, then I check the capacity
        if (cacheMap.size() >= capacity) {
            //evict the tail
            removeNode(tail);
        }
        CacheNode newNode = new CacheNode(key, value);
        addNode(newNode);
    }

    private void addNode(CacheNode node){
        cacheMap.put(node.key, node);
        insertToFirst(node);
    }

    private void removeNode(CacheNode node){
        CacheNode preTail = tail.pre;
        tail = preTail;
        detachNode(node);
        cacheMap.remove(node.key);
    }
    private void detachNode(CacheNode node){
        CacheNode previous = node.pre;
        CacheNode next = node.next;
        if (previous != null) {
            previous.next = next;
        }
        if (next != null) {
            next.pre = previous;
        }
        if (node.key == tail.key) {
            tail = node.pre;
        }
    }
    private void insertToFirst(CacheNode node){
        CacheNode next = header.next;
        if (next == null) {
            tail = node;
        }
        header.next = node;
        node.next = next;
        node.pre = header;
        if (next != null) {
            next.pre = node;
        }
    }


    public static void main(String[] args){
        LRUCache cache = new LRUCache(1);
        cache.put(2,1);
        cache.get(2);
        cache.put(3,2);
        cache.get(2);
        cache.get(3);
    }
}

class CacheNode{
    int key;
    int value;
    CacheNode(){

    }
    CacheNode(int key, int value){
        this.key = key;
        this.value = value;
    }
    CacheNode pre;
    CacheNode next;
}
