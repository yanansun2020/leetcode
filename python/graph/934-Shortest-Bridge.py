from typing import List
class Solution:
    # multi source and multi destination problem
    # dfs to locate the first island
    # bfs tolocate the distance
    def shortestBridge(self, A: List[List[int]]) -> int:
        rows = len(A)
        cols = len(A[0])
        queue = []
        flag = False
        for i in range(rows):
            if flag == True:
                break
            for j in range(cols):
                if A[i][j] == 1:
                    self.dfs(i, j, A, queue)
                    flag = True
                    break
        steps = 0
        tuples = [(-1, 0), [1, 0], [0, -1], [0, 1]]
        while queue:
            tmp_queue = []
            steps += 1
            for x, y in queue:
                for x_offset, y_offset in tuples:
                    x_ = x + x_offset
                    y_ = y + y_offset
                    if x_ < 0 or y_ < 0 or x_ == rows or y_ == cols:
                        continue
                    if A[x_][y_] == 0:
                        A[x_][y_] = 2
                        tmp_queue.append([x_, y_])
                    elif A[x_][y_] == 2:
                        continue
                    elif A[x_][y_] == 1:
                        return steps -1
            queue = tmp_queue
        return -1

    def dfs(self, x, y, A, queue):
        if x<0 or y<0 or x==len(A) or y == len(A[0]):
            return
        if A[x][y] != 1:
            return
        queue.append([x, y])
        A[x][y] = 2
        self.dfs(x-1, y, A, queue)
        self.dfs(x+1, y, A, queue)
        self.dfs(x, y-1, A, queue)
        self.dfs(x, y+1, A, queue)

def main():
    sol = Solution()
    result = sol.shortestBridge([[0,1,0],[0,0,0],[0,0,1]])
    print(result)
if __name__ == "__main__":
    main()

