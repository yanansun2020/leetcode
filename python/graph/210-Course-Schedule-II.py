from typing import List
from collections import defaultdict
class Solution:
    # topoligical sort
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        white_array = [i for i in range(numCourses)]
        if not prerequisites:
            return white_array
        # init graph
        graph = defaultdict(list)
        for i, j in prerequisites:
            graph[i].append(j)
        grey_array = []
        black_array = []
        for course in range(numCourses):
            if course in black_array:
                continue
            if not self.dfs(course, white_array, grey_array, black_array, graph):
                return []
        return black_array

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
    result = sol.findOrder(2,[[0,1]])
    print(result)
    # result = sol.findOrder(3,[[1,0]])
    # print(result)
    # result = sol.findOrder(1,[])
    # print(result)
    # result = sol.findOrder(4, [[1,0],[2,0],[3,1],[3,2]])
    # print(result)
    # result = sol.findOrder(2, [[1,0],[0,1]])
    # print(result)
    # result = sol.findOrder(2, [[1,0]])
    # print(result)
    # result = sol.findOrder(8, [[1,0],[2,6],[1,7],[5,1],[6,4],[7,0],[0,5]])
    # print(result)


if __name__ == "__main__":
    main()
