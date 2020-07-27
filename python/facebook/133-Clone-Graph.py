"""
# Definition for a Node.
"""
from collections import defaultdict
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        # dfs below
        # memo = defaultdict(Node)
        # self.dfs(node, None, memo)
        # return memo[node.val]
        # bfs below
        result = self.bfs(node)
        return result


    def dfs(self, node, parent_node, memo):
        if node.val in memo:
            memo[node.val].neighbors.append(parent_node)
            return
        tmp_node = Node(node.val)
        if node.val not in memo:
            memo[node.val] = tmp_node
            if parent_node:
                tmp_node.neighbors.append(parent_node)
                # parent_node.neighbors.append(tmp_node)
        for neighbor in node.neighbors:
            self.dfs(neighbor, tmp_node, memo)

    def bfs(self, node):
        queue1 = [node]
        head = Node(node.val)
        visited = {head.val:head}
        while queue1:
            node1 = queue1[0]
            for neighbor in node1.neighbors:
                if neighbor.val not in visited:
                    visited[neighbor.val] = Node(neighbor.val)
                    queue1.append(neighbor)
                visited[node1.val].neighbors.append(visited[neighbor.val])
            queue1.pop(0)
        return head


def main():
    sol = Solution()
    node1 = Node(1)
    node2 = Node(2)
    node3 = Node(3)
    node4 = Node(4)
    neighbor_1 = [node2, node4]
    neighbor_2 = [node1, node3]
    neighbor_3 = [node2, node4]
    neighbor_4 = [node1, node3]
    node1.neighbors = neighbor_1
    node2.neighbors = neighbor_2
    node3.neighbors = neighbor_3
    node4.neighbors = neighbor_4

    result = sol.cloneGraph(node1)
    print(result)
    # result = sol.flatten([1,2,3,0,0,0], 3,[2, 5,6], 3 )
    # print(result)

if __name__ == "__main__":
    main()


        # node_2 is copy of node 1
        # node_2 = Node(0)
        # head = node_2

        # node_1_queue = [node]
        # node_2_queue = [node_2]
        # while queue_original:
        #     node1 = node_1_queue[0]
        #     node2 = node_2_queue[0]
        #     node2.neighbors.append(Node(node1.val))
        #     for neighbor in node1.neighbors:
        #         node_1_queue.append(neighbor)

        #     node_1_queue.pop(0)
        #     node_2_queue.pop(0)

