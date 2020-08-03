from typing import List
from collections import deque
from collections import defaultdict
class Solution:
    # union find
    def isBipartite(self, graph: List[List[int]]) -> bool:
        N = len(graph)
        parent = [i for i in range(N)]
        def find(node, parent):
            if node == parent[node]:
                return node
            parent_ = find(parent[node], parent)
            parent[node] = parent_
            return parent_

        for i in range(N):
            if not graph[i]:
                continue
            parent_i = find(i, parent)
            parent_j_0 = find(graph[i][0], parent)
            if parent_i == parent_j_0:
                return False
            for j in range(1, len(graph[i])):
                parent_j = find(graph[i][j], parent)
                if parent_i == parent_j:
                    return False
                else:
                    parent[graph[i][j]] = parent_j_0
        return True

    def isBipartite_bfs(self, graph: List[List[int]]) -> bool:
        def bfs(index, memo):
            # node +depth
            queue = deque([index])
            while queue:
                node = queue.popleft()
                if node not in memo:
                    memo[node] = 1
                next_nodes = graph[node]
                if next_nodes:
                    node_group = memo[node]
                    for next_node in next_nodes:
                        if next_node not in memo:
                            memo[next_node] = -node_group
                            queue.append(next_node)
                        else:
                            if memo[next_node] == node_group:
                                return False
            return True
        for i in range(len(graph)):
            memo = defaultdict(int)
            if not bfs(i, memo):
                return False
        return True

    def isBipartite_dfs(self, graph: List[List[int]]) -> bool:
        def dfs(index, white_list, black_list):
            if index in black_list:
                return False
            if index in white_list:
                return True
            white_list.append(index)
            node = graph[index]
            if not node:
                return True
            for i in node:
                if not dfs(i, black_list, white_list):
                    return False
            return True
        for i in range(len(graph)):
            white_list = []
            black_list = []
            if not dfs(i, white_list, black_list):
                return False
        return True
def main():
    sol = Solution()
    result = sol.isBipartite([[1,3], [0,2], [1,3], [0,2]])
    print(result)
    result = sol.isBipartite([[1,2,3], [0,2], [0,1,3], [0,2]])
    print(result)

if __name__ == "__main__":
    main()
