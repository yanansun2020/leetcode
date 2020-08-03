from collections import defaultdict
from typing import List
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not prerequisites:
            return True
        # init graph
        graph = defaultdict(list)
        for i, j in prerequisites:
            graph[i].append(j)
        white_array = [i for i in range(numCourses)]
        grey_array = []
        black_array = []
        for course in white_array:
            if not graph[course]:
                continue
            if not self.dfs(course, white_array, grey_array, black_array, graph):
                return False
        return True

    def dfs(self, course, white_array, grey_array, black_array, graph):
        self.move_from_white_to_grey(course, white_array, grey_array)
        neighbors = graph[course]
        for neighbor in neighbors:
            if neighbor in black_array:
                continue
            if neighbor in grey_array:
                return False
            if not self.dfs(neighbor, white_array, grey_array, black_array, graph):
                return False
        self.move_from_grey_to_black(course, grey_array, black_array)
        return True

    def move_from_white_to_grey(self, value, white_array, grey_array):
        white_array.remove(value)
        grey_array.append(value)
    def move_from_grey_to_black(self, value, grey_array, black_array):
        grey_array.remove(value)
        black_array.append(value)


def main():
    sol = Solution()
    result = sol.canFinish(2, [[1,0],[0,1]])
    print(result)
    result = sol.canFinish(2, [[1,0]])
    print(result)
    result = sol.canFinish(8, [[1,0],[2,6],[1,7],[5,1],[6,4],[7,0],[0,5]])
    print(result)


if __name__ == "__main__":
    main()
