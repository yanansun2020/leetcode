package oa.ms.vo;

class MyHashMap {

    /** Initialize your data structure here. */
    int[] hashTable;
    public MyHashMap() {
        hashTable = new int[100001];
        for(int i =0; i<100001; i++){
            hashTable[i] = -1;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        hashTable[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashTable[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashTable[key] = -1;
    }
}
