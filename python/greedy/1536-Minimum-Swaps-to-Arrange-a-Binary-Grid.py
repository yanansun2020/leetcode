class Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        M = len(grid)
        for i in range(M):
            for j in range(i, M):
