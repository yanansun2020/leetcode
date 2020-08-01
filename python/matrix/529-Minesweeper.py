from typing import List
class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        x, y = click
        if board[x][y] == "M":
            board[x][y] = "X"
            return board
        def dfs(i, j, visited):
            if i < 0 or i > len(board)-1 or j <0 or j > len(board[0])-1:
                return
            if board[i][j] != "E":
                return
            if (i, j) in visited:
                return
            visited.append((i, j))
            mine_number = self.getAdjacentMine(i, j, board)
            if mine_number > 0:
                board[i][j] = str(mine_number)
                return
            else:
                board[i][j] = "B"
                array = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1],[1, 1], [-1, 1], [1, -1] ]
                for m, n in array:
                    dfs(i + m, j + n, visited)
        dfs(x, y, [])
        return board

    def getAdjacentMine(self, i, j, board):
        count = 0
        mine = "M"
        array = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1],[1, 1], [-1, 1], [1, -1] ]
        for k, p in array:
            row = i + k
            col = j + p
            if row < 0 or row > len(board) -1 or col < 0 or col > len(board[0])-1:
                continue
            if board[row][col] == mine:
                count += 1
        return count

def main():
    sol = Solution()
    result = sol.updateBoard([['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']], [3,0])
    print(result)
    result = sol.updateBoard([['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']], [1,2])
    print(result)

if __name__ == "__main__":
    main()
