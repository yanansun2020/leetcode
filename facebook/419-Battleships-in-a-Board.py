from typing import List
class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        if not board:
            return 0
        rows = len(board)
        cols = len(board[0])
        result = 0
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == "X":
                    if i == 0 and j == 0:
                        result += 1
                        continue
                    if i == 0 and board[i][j-1] != "X":
                        result += 1
                        continue
                    if j == 0 and i > 0 and board[i-1][j] != "X":
                        result += 1
                        continue
                    if i > 0 and j > 0 and board[i-1][j] != "X" and board[i][j-1] != "X":
                        result +=1
        return result

def main():
    sol = Solution()
    result = sol.countBattleships([["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]])
    print(result)
    result = sol.countBattleships([["X",".",".","X"],[".",".",".","X"],["X",".",".","X"]])
    print(result)
if __name__ == "__main__":
    main()