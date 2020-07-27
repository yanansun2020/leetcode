from collections import defaultdict
from typing import List
import copy
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        start_points = defaultdict(list)
        rows = len(board)
        cols = len(board[0])
        for i in range(rows):
            for j in range(cols):
                start_points[board[i][j]].append((i, j))
        start_point = start_points[word[0]]

        for i, j in start_point:
            if self.dfs(board, i, j, word, 0):
                return True
        return False

    def dfs(self, board, i, j, word, word_index)->bool:
        if word_index > len(word) -1:
            return True
        if i < 0 or j <0 or i>len(board)-1 or j >len(board[0])-1:
            return False
        if board[i][j] == word[word_index]:
            tmp = str(board[i][j])
            board[i][j] = '$'
            result = self.dfs(board, i -1, j, word, word_index + 1) or\
                self.dfs(board, i, j+1, word, word_index + 1) or\
                    self.dfs(board, i+1, j, word, word_index + 1) or\
                        self.dfs(board, i, j-1, word, word_index + 1)
            board[i][j] = tmp
            return result
        else:
            return False

def main():
    sol = Solution()
    board = \
        [
            ['A','B','C','E'],
            ['S','F','C','S'],
            ['A','D','E','E']
        ]

    result = sol.exist(board, "ABCCED")
    print(result)
    result = sol.exist(board, "SEE")
    print(result)
    result = sol.exist(board, "ABCB")
    print(result)
    result = sol.exist(board, "FCSM")
    print(result)
    board = \
    [
        ['A']
    ]
    result = sol.exist(board, "A")
    print(result)
    board = [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
    result = sol.exist(board, "ABCEFSADEESE")
    print(result)
    # result = sol.findMedianSortedArrays([0,0], [0, 0])
    # print(result)
    # result = sol.findMedianSortedArrays([1,2], [3])
    # print(result)
    # result = sol.findMedianSortedArrays([3], [-2,-1])
    # print(result)
    # result = sol.exist()
    # print(result)
if __name__ == "__main__":
    main()