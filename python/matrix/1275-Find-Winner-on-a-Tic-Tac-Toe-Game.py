class Node:
    def __init__(self, val, count):
        self.val = val
        self.count = count
from typing import List
class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        win = [[0,1,2],[3,4,5],[6,7,8],[0,3,6],[1,4,7],[2,5,8],[0,4,8],[2,4,6]]

        ##draw the 3*3 empty chessboard
        matrix = ['']*9

        ##put the chess into chessboard
        for i in range(0,len(moves),2):
            p = moves[i][0]*3+moves[i][1]
            matrix[p] = 'A'

        for i in range(1,len(moves),2):
            p = moves[i][0]*3+moves[i][1]
            matrix[p] = 'B'

        ##check if meet win condition
        for a,b,c in win:
            if matrix[a] == matrix[b] == matrix[c] and matrix[a]!='':
                return matrix[a]

        if len(moves)==9:
            return 'Draw'

        return 'Pending'
def main():
    sol = Solution()
    result = sol.tictactoe([[0,0],[2,0],[1,1],[2,1],[2,2]])
    print(result)
    # result = sol.minSubArrayLen("ADOABC", "ABC")
    # print(result)
    # result = sol.minSubArrayLen("ADOABCODEBANC", "ABC")
    # print(result)

if __name__ == "__main__":
    main()