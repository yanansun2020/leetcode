from collections import defaultdict
from typing import List
#graph dfs
class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        graph = defaultdict(list)
        for index, edge in enumerate(equations):
            graph[edge[0]].append((edge[1], values[index]))
            graph[edge[1]].append((edge[0], 1/ values[index]))
        result = []

        for edge in queries:
            start = edge[0]
            end = edge[1]
            dfs_result = self.dfs(start, end, graph, [])
            result.append(dfs_result if dfs_result else -1.0)
        return result

    def dfs(self, start, end, graph, visited):
        if end not in graph:
            return -1.0
        visited.append(start)
        if start == end:
            return 1.0
        neighbors =  graph[start]
        if not neighbors:
            return -1.0
        for neighbor, value in neighbors:
            if neighbor in visited:
                continue
            ans = self.dfs(neighbor, end, graph, visited)
            if not ans or ans < 0:
                continue
            return value * ans

def main():
    sol = Solution()
    # result = sol.calcEquation([ ["a", "b"], ["b", "c"]], [2.0, 3.0], \
    #     [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ])
    # print(result)
#     result = sol.calcEquation([["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]],\
#         [3.0,4.0,5.0,6.0],\
# [["x1","x5"],["x5","x2"],["x2","x4"],["x2","x2"],["x2","x9"],["x9","x9"]])
#     print(result)
    result = sol.calcEquation([["a","b"],["c","d"]], [1.0,1.0], [["a","c"],["b","d"],["b","a"],["d","c"]])
    print(result)

if __name__ == "__main__":
    main()
