from collections import deque
from collections import defaultdict
# map + doublelinked list
class Node:
    def __init__(self,key=0,val=0,pre=None,nex=None):
        self.key = key
        self.val = val
        self.prev = pre
        self.next = nex

class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = defaultdict(Node)
        self.head = Node(-1, -1) #The most recent used one
        self.tail = Node(-1, -1, self.head, None) # The least recent used one
        self.head.next = self.tail

    def get(self, key: int) -> int:
        if key in self.map:
            node = self.map[key]
            self.remove(node)
            self.add(node)
            return node.val
        return -1

    def put(self, key: int, value: int) -> None:
        # if key is alreay exists, update it to head
        if key in self.map:
            self.remove(self.map[key])
        cur_node = Node(key, value)
        self.map[key] = cur_node
        self.add(cur_node)
        # if list is full, remove least recent used key
        if len(self.map) > self.capacity:
            node = self.tail.prev
            self.remove(node)
            del self.map[node.key]

    def add(self, cur_node):
        tmp_node = self.head.next
        self.head.next = cur_node
        cur_node.next = tmp_node
        cur_node.prev = self.head
        tmp_node.prev = cur_node

    def remove(self, node):
        previous = node.prev
        next_ = node.next
        previous.next = next_
        next_.prev = previous


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
def main():
    cache = LRUCache(2)
    result = cache.put(1, 1)
    result = cache.put(2, 2)
    result = cache.get(1)
    print(result)
    result = cache.put(3, 3)
    print(result)
    result = cache.get(2)
    print(result)
    result = cache.put(4, 4)
    print(result)
    print(result)
    result = cache.get(1)
    print(result)
    result = cache.get(3)
    print(result)
    result = cache.get(4)
    print(result)


if __name__ == "__main__":
    main()