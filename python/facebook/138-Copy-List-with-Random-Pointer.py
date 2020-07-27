"""
# Definition for a Node.
"""
from collections import defaultdict
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        node1 = head
        copy_node = Node(head.val)
        memo = defaultdict()
        memo[node1] = copy_node
        while node1:
            next1 = node1.next
            random1 = node1.random
            if not memo.get(node1):
                memo[node1] = Node(node1.val)
            if not memo.get(next1) and next1:
                memo[next1] = Node(next1.val)
            if not memo.get(random1) and random1:
                memo[random1] = Node(random1.val)
            memo[node1].next = memo[next1] if memo.get(next1) else None
            memo[node1].random = memo[random1] if memo.get(random1) else None
            node1 = node1.next
        return memo[head]

def main():
    sol = Solution()
    node_1 = Node(7)
    node_2 = Node(13)
    node_1.next = node_2
    node_2.random = node_1
    result = sol.copyRandomList(node_1)
    print(result)

if __name__ == "__main__":
    main()
