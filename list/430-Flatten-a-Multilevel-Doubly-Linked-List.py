
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child

class Solution:
    #dfs+stack:
    def flatten_stack(self, head: 'Node') -> 'Node':
        if not head: return head
        stack, order = [head], []

        while stack:
            last = stack.pop()
            order.append(last)
            if last.next:
                stack.append(last.next)
            if last.child:
                stack.append(last.child)

        for i in range(len(order) - 1):
            order[i+1].prev = order[i]
            order[i].next = order[i+1]
            order[i].child = None

        return order[0]
    #dfs _ recursive
    def flatten(self, head: 'Node') -> 'Node':
        if not head:
            return None
        def dfs(node, next_node):
            while node:
                if not node.child and not node.next:
                    if not next_node:
                        return
                    node.next = next_node[-1]
                    next_node[-1].prev = node
                    return
                if node.child:
                    next_node.append(node.next)
                    node.next = node.child
                    node.child.prev = node
                    node.child = None
                    # next_node[-1].prev = None
                    dfs(node.next, next_node)
                    next_node.pop(-1)
                node = node.next
        node = head
        dfs(node, [])
        return head
def main():
    sol = Solution()
    node_11 = Node(11, None, None, None)
    node_12 = Node(12, node_11, None, None)
    node_11.next = node_12

    node_9 = Node(9, None, None, None)
    node_10 = Node(10, node_9, None, None)
    node_9.next = node_10


    node_7 = Node(7, None, None, None)
    node_8 = Node(8, node_7, node_9, node_11)
    node_7.next = node_8

    result = sol.flatten(node_7)
    print(result)

if __name__ == "__main__":
    main()
